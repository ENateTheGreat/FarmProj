import java.util.Objects;

public class AdvancedIrrigationStrategy extends IrrigationStrategy {


    public String determineIrrigationAmount(
            double moistureLevel,
            String weatherCondition,
            double cropWaterRequirement
    ) {
        double weather = moistureMultFromWeather(weatherCondition);
        double baseIrrigationAmount = 0;

        if (cropWaterRequirement < 30) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= .5;
        } else if (cropWaterRequirement < 60) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 1.0;
        } else if (cropWaterRequirement < 90) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 1.5;
        } else if (cropWaterRequirement >= 90) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 2.0;
        } else {
            return "Please run the sensors before calculating a plan.";
        }
        return baseIrrigationAmount + " Minutes of irrigation needed.";
    }

    public double weatherConditions(double weather, double moistureLevel) {

        double irrigationAmount = 0;

        if (weather == 0) {
            return 0;
        } else if (moistureLevel == 100) {
            return 0;
        } else if (moistureLevel < 100 && moistureLevel >= 75) {
            irrigationAmount = 15 * weather;
            return irrigationAmount;
        } else if (moistureLevel < 75 && moistureLevel >= 50) {
            irrigationAmount = 30 * weather;
            return irrigationAmount;
        } else if (moistureLevel < 50 && moistureLevel >= 25) {
            irrigationAmount = 45 * weather;
            return irrigationAmount;
        } else if  (moistureLevel < 25 && moistureLevel >= 0) {
            irrigationAmount = 60 * weather;
            return irrigationAmount;
        } else {
            return 0;
        }
    }

    public String scheduleIrrigation(String weatherStr, double moistureLevel, double cropWaterRequirement) {
        double weather = moistureMultFromWeather(weatherStr);
        double weatherCondition = weatherConditions(weather, moistureLevel);
        String irrigationAmount = determineIrrigationAmount(moistureLevel, weatherStr, cropWaterRequirement);

        if (weatherCondition == 0) return "Irrigation not needed, scheduling cancelled.";

        if (Objects.equals(irrigationAmount, "Please run the sensors before calculating a plan.")) {
            return "Please run the sensors before calculating a plan.";
        }

        if (weatherCondition >= 100) {
            return "Irrigation scheduled for 8 A.M. and 8 P.M. " + irrigationAmount;
        } else if (weatherCondition >= 80) {
            return "Irrigation scheduled for 10 A.M. and 6 P.M " + irrigationAmount;
        } else if (weatherCondition >= 60) {
            return "Irrigation scheduled for 12 P.M. and 8 P.M " + irrigationAmount;
        } else if (weatherCondition >= 40) {
            return "Irrigation scheduled for 8 A.M. " + irrigationAmount;
        } else if (weatherCondition >= 20) {
            return "Irrigation scheduled for 11 A.M. " + irrigationAmount;
        } else return "Please run the sensors before calculating a plan.";
    }

    public String considerSoilAndTopography() {
        return ""; // ??????????????????
    }

    public double waterInGallons(
            double moistureLevel,
            String weatherCondition,
            double cropWaterRequirement
    ) {
        double weather = moistureMultFromWeather(weatherCondition);
        double baseIrrigationAmount = 0;

        if (cropWaterRequirement < 30) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 1;
        } else if (cropWaterRequirement < 60) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 2;
        } else if (cropWaterRequirement < 90) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 3;
        } else if (cropWaterRequirement >= 90) {
            baseIrrigationAmount = weatherConditions(weather, moistureLevel);
            baseIrrigationAmount *= 4;
        } else {
            return 0;
        }
        return baseIrrigationAmount;
    }
}
