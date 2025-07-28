package testfailer;

public class SensorStub implements IWeatherSensor {
    private final double temperature;
    private final int precipitation;
    private final int windSpeed;
    private final int humidity;

    public SensorStub(double temperature, int precipitation, int windSpeed, int humidity) {
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }


    @Override
    public int Humidity() {
        return humidity; // Stubbed humidity
    }

    @Override
    public int Precipitation() {
        return precipitation; // Stubbed precipitation
    }

    @Override
    public double TemperatureInC() {
        return temperature; // Stubbed temperature
    }

    @Override
    public int WindSpeedKMPH() {
        return windSpeed; // Stubbed wind speed
    }
}
