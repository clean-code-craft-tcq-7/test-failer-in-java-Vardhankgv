package testfailer;

import static org.junit.Assert.*;
import org.junit.Test;

import testfailer.IWeatherSensor;
import testfailer.SensorStub;
import testfailer.WeatherReport;

public class WeatherReportTest {

    @Test
    public void testSunnyDay() {
        IWeatherSensor sensor = new SensorStub(26, 10, 30, 50); // Temperature > 25 and low precipitation
        String report = WeatherReport.getReport(sensor);
        assertEquals("Sunny Day", report);
    }

    @Test
    public void testSunnyDayBoundary() {
        IWeatherSensor sensor = new SensorStub(26, 19, 30, 50); // Temperature > 25 and precipitation < 20
        String report = WeatherReport.getReport(sensor);
        assertEquals("Sunny Day", report);
    }

    @Test
    public void testPartlyCloudy() {
        IWeatherSensor sensor = new SensorStub(26, 30, 20, 50); // Partly cloudy conditions
        String report = WeatherReport.getReport(sensor);
        assertEquals("Partly Cloudy", report);
    }

    @Test
    public void testHumidAndPartlyCloudy() {
        IWeatherSensor sensor = new SensorStub(26, 30, 20, 75); // High humidity
        String report = WeatherReport.getReport(sensor);
        assertEquals("Humid and Partly Cloudy", report);
    }

    @Test
    public void testStormyWithHeavyRain() {
        IWeatherSensor sensor = new SensorStub(27, 70, 55, 80); // Stormy conditions
        String report = WeatherReport.getReport(sensor);
        assertEquals("Alert, Stormy with heavy rain", report);
    }

    @Test
    public void testRainyDayLowWind() {
        IWeatherSensor sensor = new SensorStub(26, 70, 40, 50); // High precipitation with low wind
        String report = WeatherReport.getReport(sensor);
        assertEquals("Rainy Day", report);
    }

    @Test
    public void testHighPrecipitationLowWind() {
        IWeatherSensor sensor = new SensorStub(26, 70, 40, 40); // High precipitation
        String report = WeatherReport.getReport(sensor);
        assertEquals("Rainy Day", report); // Should indicate rain
    }

    @Test
    public void testLowTemperature() {
        IWeatherSensor sensor = new SensorStub(24, 50, 60, 50); // Low temperature
        String report = WeatherReport.getReport(sensor);
        assertEquals("Sunny Day", report); // Temperature is not above 25
    }

    @Test
    public void testBoundaryConditions() {
        IWeatherSensor sensor = new SensorStub(25, 20, 50, 50); // Exactly at the boundary
        String report = WeatherReport.getReport(sensor);
        assertEquals("Sunny Day", report); // Should return sunny day
    }

    @Test
    public void testHighTemperatureLowPrecipitation() {
        IWeatherSensor sensor = new SensorStub(30, 10, 60, 50); // Low precipitation
        String report = WeatherReport.getReport(sensor);
        assertEquals("Sunny Day", report); // Low precipitation
    }

    @Test
    public void testHumidAndRainyDay() {
        IWeatherSensor sensor = new SensorStub(26, 70, 40, 80); // High humidity and high precipitation
        String report = WeatherReport.getReport(sensor);
        assertEquals("Humid and Rainy Day", report);
    }
}
