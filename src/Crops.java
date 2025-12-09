public abstract class Crops {
    public String name;
    public String growthStage;
    public String diseaseResistance;
    public double waterRequirement;
    public String health;
    public boolean isInfested;

    public Crops(
            String name,
            String growthStage,
            String diseaseResistance,
            double waterRequirement,
            String health
    ) {
        this.name = name;
        this.growthStage = growthStage;
        this.diseaseResistance = diseaseResistance;
        this.waterRequirement = waterRequirement;
        this.health = health;
        this.isInfested = false;
    }

    public abstract String getHealth();
    public abstract boolean getPest();
    public abstract void setPest(boolean pest);
    public abstract String getGrowth();
    public abstract double getWaterRequirement();
    public abstract String getName();
    public abstract void setHealth(String health);
}
