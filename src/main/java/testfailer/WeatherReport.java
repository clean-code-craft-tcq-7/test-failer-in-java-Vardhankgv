package testfailer;

public class WeatherReport {

    private static final double TEMPERATURE_THRESHOLD = 25.0;
    private static final int PARTLY_CLOUDY_PRECIPITATION_MIN = 20;
    private static final int PARTLY_CLOUDY_PRECIPITATION_MAX = 60;
    private static final int STORMY_PRECIPITATION_THRESHOLD = 60;
    private static final int STORMY_WIND_SPEED_THRESHOLD = 50;
    private static final int HIGH_HUMIDITY_THRESHOLD = 70;

    /**
     * Generates a weather report based on the provided weather sensor data.
     *
     * @param sensor the weather sensor providing data
     * @return a string representing the weather report
     */
    public static String getReport(IWeatherSensor sensor) {
        double temperature = sensor.TemperatureInC();
        int precipitation = sensor.Precipitation();
        int windSpeed = sensor.WindSpeedKMPH();
        int humidity = sensor.Humidity();
        String report = "Sunny Day";

        if (temperature > TEMPERATURE_THRESHOLD && precipitation < PARTLY_CLOUDY_PRECIPITATION_MIN) {
            report = "Sunny Day";
        } else if (temperature > TEMPERATURE_THRESHOLD && precipitation >= PARTLY_CLOUDY_PRECIPITATION_MIN && precipitation < PARTLY_CLOUDY_PRECIPITATION_MAX) {
            report = humidity > HIGH_HUMIDITY_THRESHOLD ? "Humid and Partly Cloudy" : "Partly Cloudy";
        } else if (precipitation >= STORMY_PRECIPITATION_THRESHOLD) {
            if (windSpeed > STORMY_WIND_SPEED_THRESHOLD) {
                report = "Alert, Stormy with heavy rain";
            } else {
                report = humidity > HIGH_HUMIDITY_THRESHOLD ? "Humid and Rainy Day" : "Rainy Day";
            }
        }

        return report;
    }
}
