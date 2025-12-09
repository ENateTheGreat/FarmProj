public class Chicken extends Livestock {
    public int heartRate;
    public int respiratoryRate;
    public String activityLevel;
    public double temperature;
    public int eggsDaily;


    public Chicken(String animalName, int weight, double temperature, int heartRate,
                   int respiratoryRate, String activityLevel, String animalType, boolean isFed, String foodType, int eggsDaily) {
        super(animalName, weight, animalType, isFed, foodType,
                heartRate, respiratoryRate, activityLevel, temperature);
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.activityLevel = activityLevel;
        this.temperature = temperature;
    }


    public void displayInfo() {
        System.out.print("Eggs produced today: " + eggsDaily);
    }
}
