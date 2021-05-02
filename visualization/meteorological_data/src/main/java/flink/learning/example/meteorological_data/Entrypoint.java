package flink.learning.example.meteorological_data;

import flink.learning.example.meteorological_data.table.*;

public class Entrypoint {
    public static void main(String[] args) throws Exception {
        if (0 == args.length) {
            regularJob(args);
            return;
        }
        if ("regular".equals(args[0])) {
            regularJob(args);
        } else if ("table".equals(args[0])&&"temperature".equals(args[1])) {
            temperatureJob(args);
        } else if ("table".equals(args[0])&&"humidity".equals(args[1])) {
            humidityJob(args);
        } else if ("table".equals(args[0])&&"rainfall".equals(args[1])) {
            rainfallJob(args);
        } else if ("table".equals(args[0])&&"windPower".equals(args[1])) {
            windPowerJob(args);
        } else if ("table".equals(args[0])) {
            tableJob(args);
        } else {
            throw new RuntimeException("invalid arguments");
        }
    }

    private static void regularJob(String[] args) throws Exception {
        MeteorologicalDataStream.main(args);
    }

    private static void tableJob(String[] args) throws Exception {
        StreamJob.main(args);
    }

    private static void temperatureJob(String[] args) throws Exception {
        TemperatureJob.main(args);
    }

    private static void humidityJob(String[] args) throws Exception {
        HumidityJob.main(args);
    }

    private static void rainfallJob(String[] args) throws Exception {
        RainfallJob.main(args);
    }

    private static void windPowerJob(String[] args) throws Exception {
        WindPowerJob.main(args);
    }
}
