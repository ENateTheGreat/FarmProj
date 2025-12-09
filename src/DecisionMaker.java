public interface DecisionMaker {
    public void makeIrrigationDecision(
            Crops crop,
            AdvancedIrrigationStrategy advStrat,
            WeatherSensor weatherSensor,
            SoilMoistureSensor soilMoistureSensor
    );
    public void makeFertilizationDecision(Crops crop);
    public void makePestControlDecision(Crops crop);
    public void detectPests(Crops crop);
}
