public abstract class IrrigationStrategy {
    public abstract String determineIrrigationAmount(
            double moistureLevel,
            String weatherCondition,
            double cropWaterRequirement
    );
    public abstract String scheduleIrrigation(
            String weather,
            double moistureLevel,
            double cropWaterRequirement
    );

    //=================================================
    // Helper Method for how weather impacts irrigation
    //=================================================
    protected double moistureMultFromWeather(String weatherCondition) {
        return switch (weatherCondition) {
            case "rainy", "snowy" -> 0;
            case "cloudy" -> 0.5;
            case "sunny" -> 1.5;
            case "blazing" -> 2;
            default -> 1;
        };
    }
}
