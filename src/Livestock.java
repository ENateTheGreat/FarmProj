public abstract class Livestock {
    private String animalName;
    private String breed;
    private int weight;
    private boolean isFed;
    private String foodType;
    public int heartRate;
    public int respiratoryRate;
    public String activityLevel;
    public double temperature;


    public Livestock(
            String animalName, int weight, String breed, boolean isFed, String foodType,
            int heartRate, int respiratoryRate, String activityLevel, double temperature
    ) {
        this.animalName = animalName;
        this.weight = weight;
        this.breed = breed;
        this.isFed = isFed;
        this.foodType = foodType;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.activityLevel = activityLevel;
        this.temperature = temperature;
    }

    public void displayInfo() {
        System.out.println("Animal Name: " + this.animalName);
        System.out.println("Animal Breed: " + this.breed);
        System.out.println("Weight: " + this.weight + " lbs");
        System.out.println("Is Fed: " + this.isFed);
        System.out.println("Food Type: " + this.foodType);
        System.out.println("Heart Rate: " + this.heartRate + " bpm");
        System.out.println("Respiratory Rate: " + this.respiratoryRate + " breaths/min");
        System.out.println("Activity Level: " + this.activityLevel);
        System.out.println("Temperature: " + this.temperature + " °F");
    }

    public void setIsFed(boolean feed)
    {
        this.isFed = feed;
    }

    public String getAnimalName() {
        return this.animalName;
    }
    public String getFoodType() {
        return this.foodType;
    }
}