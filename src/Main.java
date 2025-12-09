import java.util.Scanner;

// Group Member Names: Nathan Lee, Gro Kelrick
public class Main {
    // These should be strict singleton instances, but it gets to be over engineering at a point
    public static SoilMoistureSensor soilMoistureSensor = new SoilMoistureSensor();
    public static WeatherSensor weatherSensor = new WeatherSensor();
    public static BasicIrrigationStrategy basicIrrigationStrategy = new BasicIrrigationStrategy();
    public static AdvancedIrrigationStrategy advancedIrrigationStrategy = new AdvancedIrrigationStrategy();
    public static Manager manager = new Manager();
    public static SmartIrrigationSystem smartIrrigationSystem = new SmartIrrigationSystem(
            soilMoistureSensor,
            weatherSensor,
            basicIrrigationStrategy,
            advancedIrrigationStrategy,
            manager
    );

    public static String irrigationFrequency = "Once a day";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n");
            System.out.println("======= Farm Simulation =======");
            System.out.println("\n");

            System.out.println("1. View Sensor Data"); // View data
            System.out.println("2. Configure Settings"); // Settings?
            System.out.println("3. Perform Actions"); // auto run through the readings
            System.out.println("4. Generate Reports"); // Display data
            System.out.println("5. Manage Livestock"); // add / basic / managers
            System.out.println("6. Manage Crops"); // add / basic actions
            System.out.println("7. Smart Irrigation System");
            System.out.println("8. System Information"); // Display data
            System.out.println("9. Exit Menu");

            System.out.println("\nChoose an action: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch(mainChoice)
            {
                case 1:

                    System.out.println("Select a data type to view: ");
                    System.out.println("1. Soil Moisture Levels");
                    System.out.println("2. Weather Condition");
                    int dataChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (dataChoice == 1) {
                        System.out.println("The moisture level is: " + soilMoistureSensor.readMoistureLevel());
                    } else if (dataChoice == 2) {
                        System.out.println("The weather condition is: " + weatherSensor.readWeatherCondition());
                    } else {
                        System.out.println("Invalid input, returning user to main menu.");
                    }
                    continue;

                case 2:
                    while (true) {
                        System.out.println("Configure Settings for the system");
                        System.out.println("Current irrigation is set for: " + irrigationFrequency);
                        System.out.println("1. Once a day");
                        System.out.println("2. Twice a day");
                        System.out.println("3. Thrice a day");

                        int settingSelection = scanner.nextInt();
                        scanner.nextLine();

                        switch (settingSelection) {
                            case 1 -> {
                                irrigationFrequency = "Once a day";
                                System.out.println("The irrigation frequency is set to: " + irrigationFrequency);
                            }
                            case 2 -> {
                                irrigationFrequency = "Twice a day";
                                System.out.println("The irrigation frequency is set to: " + irrigationFrequency);
                            }
                            case 3 -> {
                                irrigationFrequency = "Thrice a day";
                                System.out.println("The irrigation frequency is set to: " + irrigationFrequency);
                            }
                            default -> {
                                System.out.println("Invalid input, please try again.");
                                continue;
                            }
                        }
                        break;
                    }

                    continue;

                case 3:
                    System.out.println("Welcome to the sensor data manager.");
                    smartIrrigationSystem.run(true);
                    continue;

                case 4:
                    System.out.println("=====REPORT GENERATION=====");
                    int sum = 0;
                    for (int i = 0; i < manager.getCrops().size(); i++) {
                        sum += (int) advancedIrrigationStrategy.waterInGallons(
                                soilMoistureSensor.readMoistureLevel(),
                                weatherSensor.readWeatherCondition(),
                                manager.getCrops().get(i).getWaterRequirement()
                        );
                    }
                    switch (irrigationFrequency) {
                        case "Once a day" -> System.out.println("Water Usage: " + sum + " gallons per day");
                        case "Twice a day" -> System.out.println("Water Usage: " + sum * 2 + " gallons per day");
                        case "Thrice a day" -> System.out.println("Water Usage: " + sum * 3 + " gallons per day");
                        default -> System.out.println("No water usage data found.");
                    }
                    continue;

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
                            Livestock livestock;
                            System.out.println("You have selected: Add Individual Animal Data");

                            System.out.println("Please input an animal type to add to the system (cow or chicken): ");
                            String animalType = scanner.nextLine();
                            System.out.println("\n\n");

                            switch (animalType) {
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
                                    System.out.println("Was this animal fed today? (yes or no): ");
                                    String answerFed = scanner.nextLine();
                                    boolean maybeFed;
                                    if (answerFed.equalsIgnoreCase("yes")) {
                                        maybeFed = true;
                                    } else {
                                        maybeFed = false;
                                    }
                                    System.out.println("What type of animal is this?: ");
                                    String type = scanner.nextLine();
                                    System.out.println("What type of food does this animal require?: ");
                                    String foodType = scanner.nextLine();

                                    manager.addLivestock(new Cow(
                                            name,
                                            weight,
                                            temperature,
                                            heartRate,
                                            respiratoryRate,
                                            animalActivityLevel,
                                            type,
                                            maybeFed,
                                            foodType
                                    ));
                                    break;
                                case "chicken":
                                    System.out.println("Please input the animal's name: ");
                                    String chickenName = scanner.nextLine();
                                    System.out.println("Please input the animal's weight (an integer): ");
                                    int chickenWeight = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Please input the animal's activity level (low, medium, or high): ");
                                    String chickenActivityLevel = scanner.nextLine();
                                    System.out.println("Please input the resting heart rate: ");
                                    int chickenHeartRate = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Please input the animal's respiratory rate:");
                                    int chickenRespiratoryRate = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Please input the animal's temperature:");
                                    double chickenTemperature = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.println("Was this animal fed today? (yes or no): ");
                                    String chickenAnswerFed = scanner.nextLine();
                                    boolean chickenMaybeFed;
                                    if (chickenAnswerFed.equalsIgnoreCase("yes")) {
                                        chickenMaybeFed = true;
                                    } else {
                                        chickenMaybeFed = false;
                                    }
                                    System.out.println("What type of animal is this?: ");
                                    String chickenType = scanner.nextLine();
                                    System.out.println("What type of food does this animal require?: ");
                                    String chickenFoodType = scanner.nextLine();

                                    manager.addLivestock(new Chicken(
                                            chickenName,
                                            chickenWeight,
                                            chickenTemperature,
                                            chickenHeartRate,
                                            chickenRespiratoryRate,
                                            chickenActivityLevel,
                                            chickenType,
                                            chickenMaybeFed,
                                            chickenFoodType
                                    ));
                                    break;
                                default:
                                    System.out.println("That is an invalid animal type.");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("You selected: View Individual Animal Data");
                            System.out.println("Here are the animals currently in the system: ");
                            for (int i = 0; i < manager.getLivestock().size(); i++) {
                                System.out.println((i+1) + ". " + manager.getLivestock().get(i).getAnimalName());
                            }

                            System.out.println("Select an animal to view their data (an integer)");
                            int animalDataChoice = scanner.nextInt();

                            manager.getLivestock().get(animalDataChoice - 1).displayInfo();
                            break;
                        case 3:
                            System.out.println("You selected: Manage Animal Health");
                            System.out.println("\n");
                            System.out.println("Select an animal to manage health. Here are the animals currently in the system: ");
                            for (int i = 0; i < manager.getLivestock().size(); i++) {
                                System.out.println((i+1) + ". " + manager.getLivestock().get(i).getAnimalName());
                            }

                            System.out.println("Select an animal to manage (an integer): ");
                            int animalHealthChoice = scanner.nextInt();

                            LivestockHealthMonitor healthMonitor = new LivestockHealthMonitor(manager.getLivestock().get(animalHealthChoice - 1));
                            healthMonitor.feedAnimal();
                            healthMonitor.checkHealth();
                            break;
                        case 4:
                            System.out.println("You selected: Manage Animal Production");
                            System.out.println("\n");
                            System.out.println("Select an animal to manage production. Here are the animals currently in the system: ");
                            for (int i = 0; i < manager.getLivestock().size(); i++) {
                                System.out.println((i+1) + ". " + manager.getLivestock().get(i).getAnimalName());
                            }

                            System.out.println("Select an animal to manage (an integer): ");
                            int animalProductionChoice = scanner.nextInt();

                            LivestockProductionManager productionManager = new LivestockProductionManager(manager.getLivestock().get(animalProductionChoice - 1));
                            productionManager.checkProduction();
                            break;
                        case 5:
                            System.out.println("Exiting to main menu.");
                            break;
                        default:
                            System.out.println("Invalid input, returning user to main menu.");
                            break;

                    }
                    continue;
                case 6:
                    System.out.println("=====CROP MANAGER=====");
                    while (true) {
                        System.out.println("Select an option from the following:");
                        System.out.println("1. Add Crops");
                        System.out.println("2. View Crops");

                        int cropSelect =  scanner.nextInt();
                        scanner.nextLine();

                        if (cropSelect != 1 && cropSelect != 2) {
                            System.out.println("Invalid input, please try again.");
                            continue;
                        }

                        switch (cropSelect) {
                            case 1:
                                System.out.println("You selected: Add Crops");
                                while (true) {
                                    System.out.println("Please select a crop to add:");
                                    System.out.println("1: Wheat");
                                    System.out.println("2: Potato");

                                    int  cropChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    if (cropChoice != 1 && cropChoice != 2) {
                                        System.out.println("Invalid input, please try again.");
                                        continue;
                                    }

                                    switch (cropChoice) {
                                        case 1 -> System.out.println("You selected: Wheat");
                                        case 2 -> System.out.println("You selected: Potato");
                                        default -> System.out.println("Invalid input, please try again.");
                                    }
                                    System.out.println("Please enter a name:");

                                    String name = scanner.nextLine();
                                    scanner.nextLine();

                                    System.out.println("Please select the growth speed:");
                                    System.out.println("1. Slow");
                                    System.out.println("2. Medium");
                                    System.out.println("3. Fast");

                                    int growthStage = scanner.nextInt();
                                    scanner.nextLine();

                                    String growthStr = "";
                                    switch (growthStage) {
                                        case 1 -> growthStr = "Slow";
                                        case 2 -> growthStr = "Medium";
                                        case 3 -> growthStr = "Fast";
                                        default -> System.out.println("Invalid input, please try again.");
                                    }

                                    System.out.println("Please select the disease resistance:");
                                    System.out.println("1. Low");
                                    System.out.println("2. Average");
                                    System.out.println("3. High");

                                    int diseaseResist = scanner.nextInt();
                                    scanner.nextLine();

                                    String diseaseStr = "";

                                    switch (diseaseResist) {
                                        case 1 -> diseaseStr = "Low";
                                        case 2 -> diseaseStr = "Average";
                                        case 3 -> diseaseStr = "High";
                                        default -> System.out.println("Invalid input, please try again.");
                                    }

                                    System.out.println("Please enter the required water in gallons:");

                                    double waterGallons = scanner.nextDouble();
                                    scanner.nextLine();

                                    System.out.println("Please select the health status: ");
                                    System.out.println("1. Healthy");
                                    System.out.println("2. Okay");
                                    System.out.println("3. Critical");

                                    int  healthStatus = scanner.nextInt();
                                    scanner.nextLine();

                                    String healthStr = "";
                                    switch (healthStatus) {
                                        case 1 -> healthStr = "Healthy";
                                        case 2 -> healthStr = "Okay";
                                        case 3 -> healthStr = "Critical";
                                        default -> System.out.println("Invalid input, please try again.");
                                    }

                                    switch (cropChoice) {
                                        case 1:
                                            manager.addCrops(
                                                    new Wheat(
                                                            name,
                                                            growthStr,
                                                            diseaseStr,
                                                            waterGallons,
                                                            healthStr
                                                    )
                                            );
                                            break;
                                        case 2:
                                            manager.addCrops(
                                                    new Potato(
                                                            name,
                                                            growthStr,
                                                            diseaseStr,
                                                            waterGallons,
                                                            healthStr
                                                    )
                                            );
                                            break;
                                    }
                                    break;
                                }
                                break;
                            case 2:
                                System.out.println("You selected: View Crops");
                                for (Crops crop : manager.getCrops()) {
                                    System.out.println("Name: " + crop.getName());
                                    System.out.println("Growth: " + crop.getGrowth());
                                    System.out.println("Infested: " + crop.getPest());
                                    System.out.println("Health: " + crop.getHealth());
                                    System.out.println("Water requirement: " + crop.getWaterRequirement() + " gallons");
                                }
                                break;
                        }

                        break;
                    }



                    continue;

                case 7:
                    smartIrrigationSystem.run(false);
                    continue;

                case 8:
                    System.out.println("System Status: Healthy - 0 Errors");
                    System.out.println("System Efficiency Vector (0-1) - 0.02");
                    System.out.println("System Software Version - v1.0.0");
                    continue;

                case 9:
                    System.out.println("Exiting menu and closing program.");
                    break;

                default:
                    System.out.println("Invalid input, try again.");
            }
        }

    }
}