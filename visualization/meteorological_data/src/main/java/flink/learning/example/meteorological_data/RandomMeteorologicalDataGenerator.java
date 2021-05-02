package flink.learning.example.meteorological_data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomMeteorologicalDataGenerator implements Iterable<String>, Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomMeteorologicalDataGenerator.class);
    private final String randomSeed;
    private final int sleep;
    private final TimeUnit timeUnit;
    private final List<String> idList;
    private transient Random random;
    private transient boolean ends;
    private transient Double lastTemperature;//温度
    private transient Double lastHumidity;//湿度
    private transient Double lastRainfall;//降水
    private transient Double lastWindPower;//风力

    public RandomMeteorologicalDataGenerator(
            String randomSeed,
            int sleep,
            TimeUnit timeUnit
    ) {
        this(randomSeed, sleep, timeUnit, null);
    }

    public RandomMeteorologicalDataGenerator(
            String randomSeed,
            int sleep,
            TimeUnit timeUnit,
            List<String> idList
    ) {
        this.randomSeed = randomSeed;
        this.sleep = sleep;
        this.timeUnit = timeUnit;
        this.idList = idList;
    }

    public boolean configured() {
        return null != lastTemperature && null != random && null != lastHumidity && null != lastRainfall && null != lastWindPower;
    }

    public void configure() throws IOException {
        random = new Random(randomSeed.hashCode());
        ends = false;
        lastTemperature = 20.0;
        lastHumidity = 50.0;
        lastRainfall = 5.0;
        lastWindPower = 1.6;
    }

    public void ends() {
        LOGGER.info("ending the generator");
        ends = true;
    }

    @Nonnull
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return !ends;
            }

            @Override
            public String next() {
                try {
                    long sleepMs = TimeUnit.MILLISECONDS.convert(sleep, timeUnit);
                    TimeUnit.MILLISECONDS.sleep(null == idList || idList.isEmpty() ? sleepMs : sleepMs / idList.size());
                } catch (InterruptedException e) {
                    LOGGER.warn(String.format("interrupted: %s", e.getMessage()), e);
                }
                double temperatureWave = random.nextDouble() * 3 - 3.0 / 2;
                double currentTemperature = lastTemperature + temperatureWave;
                lastTemperature = currentTemperature;
                double humidityWave = random.nextDouble() * 10 - 5.0;
                double currentHumidity = lastHumidity + humidityWave;
                lastHumidity = currentHumidity;
                double rainfallWave = random.nextDouble() * 3 - 1.5;
                double currentRainfall = lastRainfall + rainfallWave;
                lastRainfall = currentRainfall;
                double windPowerWave = random.nextDouble() - 0.5;
                double currentWindPower = lastWindPower + windPowerWave;
                lastWindPower = currentWindPower;

                if (null == idList || idList.isEmpty()) {
                    return String.valueOf(currentTemperature);
                } else {
                    return String.format("%s,%s,%s,%s,%s",
                            System.currentTimeMillis(), lastTemperature, lastHumidity, lastRainfall, lastWindPower);
                }
            }
        };
    }

    public String getRandomSeed() {
        return randomSeed;
    }

    public int getSleep() {
        return sleep;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
