import java.util.Random;

public class WeatherSensor implements Sensor{
    private String weatherCondition;

    @Override
    public double readMoistureLevel() {
        return 0;
    }

    @Override
    public String readWeatherCondition() {
        return this.weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public boolean hasWeatherCondition() {
        return this.weatherCondition != null && !this.weatherCondition.isEmpty();
    }
}
