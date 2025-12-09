import java.util.Objects;
import java.util.Scanner;

public class LivestockHealthMonitor
{
    public Livestock livestock;

    LivestockHealthMonitor(Livestock livestock) {this.livestock = livestock;}

    public void feedAnimal() {
        System.out.println("Would you like to feed " + livestock.getAnimalName() + "? (yes or no): ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            boolean feed = false;
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("What food would you like to feed " + livestock.getAnimalName() + "?: ");
                String food = scanner.nextLine();
                if (food.equalsIgnoreCase(livestock.getFoodType())) {
                    feed = true;
                    System.out.println(livestock.getAnimalName() + " has been fed " + food);
                } else {
                    System.out.println("That is not the correct food type for this animal.");
                }
            } else {
                feed = false;
            }
        livestock.setIsFed(feed);
    }

    public void checkHealth() {
        int strikes = 0;
        if (Objects.equals(livestock.activityLevel, "low") || Objects.equals(livestock.activityLevel, "medium")) {
            strikes = strikes + 1;
        }
        if (livestock.heartRate < 60 || livestock.heartRate > 140) {
            strikes = strikes + 1;
        }
        if (livestock.respiratoryRate < 12 || livestock.respiratoryRate > 24) {
            strikes = strikes + 1;
        }
        if (livestock.temperature < 96 || livestock.temperature > 100) {
            strikes = strikes + 1;
        }
        if (strikes < 2) {
            System.out.println("There are at least 2 concerning health indicators for " + livestock.getAnimalName() + ", medication application is recommended. Apply medication? " +
                    "(yes or no):");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                administerMedication();
            }
        } else {
            System.out.println("This animal is reasonably healthy. " +
                    "Be sure to do routine tests and in-person checks of animals to ensure their health and quality of life.");
        }
    }

    private void administerMedication() {
        System.out.println("Medication administered.");
    }
}