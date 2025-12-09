import java.sql.SQLOutput;
import java.util.Scanner;

// Group Member Names: Nathan Lee, Gro Kelrick
public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
//            throws InterruptedException { // Throw for Thread.sleep

//        WeatherSensor weatherSensor = new WeatherSensor();
//        SoilMoistureSensor  soilMoistureSensor = new SoilMoistureSensor();
//
//        double lastMoistureLevel = -1.0;
//        String lastWeather = "";
//
//        while (true) {
//            double currentMoistureLevel = soilMoistureSensor.readMoistureLevel();
//            String currentWeather = weatherSensor.readWeatherCondition();
//
//            if (currentMoistureLevel != lastMoistureLevel || !currentWeather.equals(lastWeather)) {
//                // Implement all crops that have been created here to update their data?
//                lastMoistureLevel = currentMoistureLevel;
//                lastWeather = currentWeather;
//            }
//            Thread.sleep(10000); // Check every 10 seconds
//        } ---- I think this is not needed, and we will add it to the end of the methods
//                  that change these values? or whenever a value updates, we will add these executions


        System.out.println("-------Farm Simulation-------");
        System.out.println("\n");

        System.out.println("1. View Sensor Data");
        System.out.println("2. Configure Settings");
        System.out.println("3. Perform Actions");
        System.out.println("4. Generate Reports");
        System.out.println("5. Manage Livestock");
        System.out.println("6. Manage Crops");
        System.out.println("7. System Information");
        System.out.println("8. Exit Menu");

        System.out.println("\nChoose an action: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice)
        {
            case 1:
                SoilMoistureSensor getMoistData = new SoilMoistureSensor();
                WeatherSensor getWeatherData = new WeatherSensor();

                System.out.print("Select a data type to view, weather condition or soil moisture level (1 for weather, 2 for moisture level): ");
                int dataChoice = scanner.nextInt();
                scanner.nextLine();

                if (dataChoice == 1) {
                    System.out.println("The moisture level is: " + getMoistData.readMoistureLevel());
                } else if (dataChoice == 2) {
                    System.out.println("The weather condition is: " + getWeatherData.readWeatherCondition());
                } else {
                    System.out.println("Invalid input, returning user to main menu.");
                }
                break;

            case 2:
                // configure settings
                break;

            case 3:
                SoilMoistureSensor moistStarter = new SoilMoistureSensor();
                WeatherSensor weatherStarter = new  WeatherSensor();

                moistStarter.genMoistureLevel();
                weatherStarter.genWeatherCondition();
                break;

            case 4:
                // Generate Reports
                break;

            case 5:
                System.out.println("---Livestock Actions---");
                System.out.println("\n");

                System.out.println("1. Add Individual Animal Data" );
                System.out.println("2. View Individual Animal Data" );
                System.out.println("3. Manage Animal Health" );
                System.out.println("4. Manage Animal Productivity" );
                System.out.println("5. Return to Main Menu");

                System.out.print("Select an action: ");
                int animalChoice = scanner.nextInt();
                scanner.nextLine();

                switch (animalChoice)
                {
                    case 1:
                        System.out.println("You have selected: Add Individual Animal Data");
                        System.out.println("\n\n");

                        System.out.println("Please input the animal's type (cow or chicken): ");
                            String animalType = scanner.nextLine();
                            switch (animalType)
                            {
                                case "cow":
                                    System.out.println("Please input the animal's name: ");
                                        String name = scanner.nextLine();
                                    System.out.println("Please input the animal's weight (an integer): ");
                                        int weight = scanner.nextInt();
                                        scanner.nextLine();
                                    System.out.println("Please input the animal's activity level (low, medium, or high): ");
                                        String animalActivityLevel = scanner.nextLine();
                                    System.out.println("Please input the resting heart rate: ");
                                        int heartRate = scanner.nextInt();
                                        scanner.nextLine();
                                    System.out.println("Please input the animal's respiratory rate:");
                                        int respiratoryRate = scanner.nextInt();
                                        scanner.nextLine();
                                    System.out.println("Please input the animal's temperature:");
                                        double temperature = scanner.nextDouble();
                                        scanner.nextLine();
                                    System.out.println("Please input the animal's rate of milk production in gallons: ");
                                        double milkRate = scanner.nextDouble();
                                        scanner.nextLine();
                                    System.out.println("Was this animal fed today? (yes or no): ");
                                        String maybeFed = scanner.nextLine();

                                    break;
                                case "chicken":
                                    break;
                                default:
                                    System.out.println("That is an invalid animal type.");
                            }
                }
                        break;
                    case 2:
                            // getter method calls go here
                        break;
                    case 3:
                            // another switch menu for animal health (either see animal health trend data, or
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Exiting to main menu.");
                        break;
                    default:
                        System.out.println("Invalid input, returning user to main menu.");
                }
                break;

            case 6:
                // Manage Crops
                break;

            case 7:
                // System info
                break;

            case 8:
                System.out.println("Exiting menu and closing program.");
                break;

            default:
                System.out.println("Invalid input, try again.");
        }
    }
}