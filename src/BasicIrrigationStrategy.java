import java.util.Random;

public class BasicIrrigationStrategy extends IrrigationStrategy {

    //============================
    // Determine Irrigation Method
    //============================
    public String determineIrrigationAmount(
            double moistureLevel,
            String weatherCondition,
            double cropMoistureRequirement // Not used in this class
    ) {

        double weather = moistureMultFromWeather(weatherCondition);
        double irrigationAmount = 0;

        if (weather == 0) {
            return "It is raining, no irrigation needed.";
        } else if (moistureLevel == 100) {
            return "Soil is fully moist";
        } else if (moistureLevel < 100 && moistureLevel >= 75) {
            irrigationAmount = 15 * weather;
        } else if (moistureLevel < 75 && moistureLevel >= 50) {
            irrigationAmount = 30 * weather;
        } else if (moistureLevel < 50 && moistureLevel >= 25) {
            irrigationAmount = 45 * weather;
        } else if  (moistureLevel < 25 && moistureLevel >= 0) {
            irrigationAmount = 60 * weather;
        } else {
            return "Please run the sensors before calculating a plan";
        }
        return irrigationAmount + " Minutes of irrigation needed.";
    }

    //=============================
    // Irrigation Scheduling Method
    //=============================
    public String scheduleIrrigation(String weather, double moistureLevel, double cropWaterRequirement) {
        Random random = new Random();
        int rand = random.nextInt(11);

        if (rand <= 2) {
            return "Irrigation scheduled for 8 A.M.";
        } else if (rand <= 4) {
            return "Irrigation scheduled for 10 A.M.";
        } else if (rand <= 6) {
            return "Irrigation scheduled for 12 P.M";
        } else if (rand <= 8) {
            return "Irrigation scheduled for 2 P.M.";
        } else {
            return "Irrigation scheduled for 4 P.M";
        }
    }

}
