import java.util.Random;

public class Chicken extends Livestock {
    private int randomizeEggs() {
        Random random = new Random();
        int rand = random.nextInt(2);
        return rand;
    }

    public int eggsDaily = randomizeEggs();


    public Chicken(String animalName, int weight, double temperature, int heartRate,
                   int respiratoryRate, String activityLevel, String animalType, boolean isFed, String foodType) {
        super(animalName, weight, animalType, isFed, foodType,
                heartRate, respiratoryRate, activityLevel, temperature);
    }


    public void displayInfo() {
        super.displayInfo();
        System.out.print("Eggs produced today: " + eggsDaily);
    }
}
