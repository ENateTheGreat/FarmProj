import java.util.Random;

public class Cow extends Livestock {
    private double randomizeMilkGallons() {
        Random random = new Random();
        double rand = random.nextDouble(11);
        return rand;
    }

    private double milkGallonsDaily = randomizeMilkGallons();

    public Cow
            (
            String animalName, int weight, double temperature, int heartRate, int respiratoryRate,
               String activityLevel, String animalType, boolean isFed, String foodType
    ) {
        super(animalName, weight, animalType, isFed, foodType, heartRate, respiratoryRate, activityLevel,
                temperature);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Gallons of Milk Produced Today:  " + this.milkGallonsDaily);
    }
}
