import java.util.Random;

public class SoilMoistureSensor implements Sensor {
    private Double moistureLevel;


    @Override
    public double readMoistureLevel() {
        if (moistureLevel == null) {
            throw new IllegalStateException("moistureLevel has not been set");
        }
        return this.moistureLevel;
    }

    @Override
    public String readWeatherCondition() {
        return "";
    }

    public void setMoistureLevel(double moistureLevel) {
        this.moistureLevel = moistureLevel;
    }

    public boolean hasMoistureReading() {
        return moistureLevel != null;
    }
}
