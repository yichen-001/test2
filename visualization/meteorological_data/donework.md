### 添加的Job
visualization\meteorological_data\src\main\java\flink\learning\example\meteorological_data\table目录下的
1. HumidityJob 
2. RainfallJob
3. TemperatureJob
4. WindPowerJob

### 运行方式
```
./gradlew --quiet visualization:integration:runWeb
./gradlew --quiet visualization:meteorological_data:runHumidityJob
./gradlew --quiet visualization:meteorological_data:runRainfallJob
./gradlew --quiet visualization:meteorological_data:runTemperatureJob
./gradlew --quiet visualization:meteorological_data:runWindPowerJob
```
4个Job可以选择性运行，全部运行内存可能吃不住

访问http://localhost:8080/#/wholepage 即可看到效果