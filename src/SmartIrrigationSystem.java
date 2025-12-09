import java.util.Random;
import java.util.Scanner;

public class SmartIrrigationSystem implements DecisionMaker {
    private SoilMoistureSensor soilMoistureSensor = new SoilMoistureSensor();
    private WeatherSensor weatherSensor = new WeatherSensor();
    private AdvancedIrrigationStrategy advancedIrrigationStrategy = new AdvancedIrrigationStrategy();
    private BasicIrrigationStrategy basicIrrigationStrategy = new BasicIrrigationStrategy();
    private Crops crop;
    private final Manager manager;

    private final Scanner scanner = new Scanner(System.in);

    public SmartIrrigationSystem(
            SoilMoistureSensor soilMoistureSensor,
            WeatherSensor weatherSensor,
            BasicIrrigationStrategy basicIrrigationStrategy,
            AdvancedIrrigationStrategy advancedIrrigationStrategy,
            Manager manager
    ) {
        this.soilMoistureSensor = soilMoistureSensor;
        this.weatherSensor = weatherSensor;
        this.basicIrrigationStrategy = basicIrrigationStrategy;
        this.advancedIrrigationStrategy = advancedIrrigationStrategy;
        this.manager = manager;
    }

    public void run() {
        System.out.println("Welcome to SmartIrrigationSystem");
        // System selection menu
        while (true) {
            System.out.println("Please select an option from the following: ");
            System.out.println("1. Run sensor readings");
            System.out.println("2. Enter crop management");
            System.out.println("3. View irrigation strategies");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> { // Sensor readings (manual)
                    System.out.println("Please enter the soil moisture sensor value");

                    double soilMoistureValue = scanner.nextDouble();
                    soilMoistureSensor.setMoistureLevel(soilMoistureValue);
                    scanner.nextLine();

                    while (true) {
                        System.out.println("Please select the present weather condition for the weather sensor");
                        System.out.println("1. Sunny");
                        System.out.println("2. Cloudy");
                        System.out.println("3. Rainy");
                        System.out.println("4. Snowy");
                        System.out.println("5. Heat Wave");

                        int weatherSelect = scanner.nextInt();
                        scanner.nextLine();
                        switch (weatherSelect) {
                            case 1 -> weatherSensor.setWeatherCondition("sunny");
                            case 2 -> weatherSensor.setWeatherCondition("cloudy");
                            case 3 -> weatherSensor.setWeatherCondition("rainy");
                            case 4 -> weatherSensor.setWeatherCondition("snowy");
                            case 5 -> weatherSensor.setWeatherCondition("blazing");
                            default -> {
                                System.out.println("Invalid selection, please try again.");
                                continue;
                            }
                        }

                        break;
                    }
                }

                case 2 -> {
                    // Crop management selection
                    while (true) {
                        System.out.println("=====CROP MANAGEMENT======");
                        System.out.println("Please select which crop to manage.");
                        for (int i = 0; i < manager.getCrops().size(); i++) {
                            System.out.println((i + 1) + ". " + manager.getCrops().get(i).getName());
                        }
                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid selection, please try again.");
                            scanner.nextLine();
                            continue;
                        }

                        int cropSelect = scanner.nextInt();
                        scanner.nextLine();

                        if (cropSelect >= 1 && cropSelect < manager.getCrops().size()) {
                            System.out.println("Invalid selection, please try again.");
                            continue;
                        }

                        Crops chosenCrop = manager.getCrops().get(cropSelect - 1);
                        while (true) {
                            System.out.println("You selected " + chosenCrop.getName());
                            System.out.println("Please select the action you would like to take.");
                            System.out.println("1. Monitor crop health.");
                            System.out.println("2. Apply fertilizer");
                            int cropAction = scanner.nextInt();
                            scanner.nextLine();

                            if (cropAction != 1 && cropAction != 2) {
                                System.out.println("Invalid selection, please try again.");
                                continue;
                            }

                            switch (cropAction) {
                                case 1 -> monitorCropHealth(chosenCrop);
                                case 2 -> applyFertilizer(chosenCrop);
                            }
                            break;
                        }
                        break;
                    }
                }

                case 3 -> { // View irrigation strategies
                    if (!soilMoistureSensor.hasMoistureReading() && !weatherSensor.hasWeatherCondition()) {
                        System.out.println("Please make sure that you have ran your sensors.");
                    }

                    System.out.println("=====IRRIGATION STRATEGIES=====");
                    while (true) {
                        System.out.println("Please select the strategy you wish to view");
                        System.out.println("1. Basic Irrigation");
                        System.out.println("2. Advanced Irrigation");

                        int irrSelect = scanner.nextInt();
                        scanner.nextLine();
                        if (irrSelect != 1 && irrSelect != 2) {
                            System.out.println("Invalid selection, please try again.");
                            continue;
                        }

                        switch (irrSelect) {
                          case 1 -> {
                              while (true) {
                                // implement the basic method here, ask if they want to view or schedule

                                  break;
                              }

                          }
                          case 2 -> {
                              while (true) {
                                  // Implement the advanced strategy, ask for a crop, and then if they want to view or
                                  // schedule

                                  break;
                              }
                          }
                          default -> {
                              System.out.println("Invalid selection, please try again.");
                              continue;
                          }

                        }
                        break;
                    }
                }

                default -> {
                    System.out.println("Invalid selection, try again.");
                    continue;
                }
            }
            break;
        }



        // select irrigation strategy
        // make it so if advanced, you select a crop, if basic - no crop selection


        // then for crop management, we can have them select monitor crop health or apply fertilizer


    }

    @Override
    public void makeIrrigationDecision(
            Crops crop,
            AdvancedIrrigationStrategy advStrat,
            WeatherSensor weatherSensor,
            SoilMoistureSensor soilMoistureSensor
    ) {
        double irrAmtGal = advStrat.waterInGallons(
                soilMoistureSensor.readMoistureLevel(),
                weatherSensor.readWeatherCondition(),
                crop.getWaterRequirement()
        );

        String irrAmtTime = advStrat.determineIrrigationAmount(
                soilMoistureSensor.readMoistureLevel(),
                weatherSensor.readWeatherCondition(),
                crop.getWaterRequirement()
        );

        if (advStrat.moistureMultFromWeather(weatherSensor.readWeatherCondition()) == 0) {
            System.out.println("Based on the weather, no irrigation is needed.");
        }

        if (soilMoistureSensor.readMoistureLevel() < crop.getWaterRequirement()) {
            System.out.println("Soil is adequately moist, no irrigation needed");
        }

        System.out.println(crop.getName() + " needs " + irrAmtGal + " gallons of water. " + irrAmtTime );
        // could add a sout of would you like me to schedule it?
    }

    @Override
    public void makeFertilizationDecision(Crops crop) {
        if (!crop.getHealth().equals("Healthy") || crop.getGrowth().equals("Slow")) {
            System.out.println("Fertilization is needed for " + crop.getName() + ".");
        } else {
            System.out.println("Fertilization is not needed for " + crop.getName() + ".");
        }
    }

    @Override
    public void makePestControlDecision(Crops crop) {
        if (crop.getPest()) {

            switch (crop.getHealth()) {
                case "Healthy" -> crop.setHealth("Okay");
                case "Okay" -> crop.setHealth("Critical");
                default -> crop.setHealth("Dead");
            }
            if (crop.getHealth().equals("Dead")) {
                System.out.println(crop.getName() + " is dead.");
            } else {
                System.out.println("Pest control is needed for " + crop.getName() + ".");
            }
        } else {
            System.out.println("Pest control is not needed for " + crop.getName() + ".");
        }
    }

    @Override
    public void detectPests(Crops crop) {
        Random random = new Random();
        int rand = random.nextInt(11);

        if (rand % 3 == 0) {
            System.out.println("Pest control is needed for " + crop.getName() + ".");
        }
    }

    public String monitorCropHealth(Crops crop) {
        return crop.getName() + " health: " + crop.getHealth() + ".";
    }

    public void applyFertilizer(Crops crop) {
        switch (crop.getHealth()) {
            case "Healthy", "Critical" -> crop.setHealth("Okay");
            case "Okay" -> crop.setHealth("Healthy");
            default -> crop.setHealth("Dead");
        }
    }
}
