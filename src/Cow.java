public class Cow extends Livestock {
    public double milkGallonsDaily;

    public Cow
            (
            String animalName, int weight, double temperature, int heartRate, int respiratoryRate,
               String activityLevel, String animalType, double milkGallonsDaily, boolean isFed, String foodType
    ) {
        super(animalName, weight, animalType, isFed, foodType, heartRate, respiratoryRate, activityLevel,
                temperature);
        this.milkGallonsDaily = milkGallonsDaily;
    }


    public void displayInfo() {
        System.out.println("Gallons of Milk Produced Today:  " + this.milkGallonsDaily);
    }
}
