public class Wheat extends Crops{

    public Wheat(
            String name,
            String growthStage,
            String nutrientRequirements,
            String diseaseResistance,
            double waterRequirement,
            String health
    ) {
        super(
                "Wheat" + name,
                growthStage,
                nutrientRequirements,
                diseaseResistance,
                waterRequirement,
                health
        );
    }

    @Override
    public String getHealth() {
        return super.health;
    }

    @Override
    public boolean getPest() {
        return false;
    }

    @Override
    public void setPest(boolean pest) {
        super.isInfested = pest;
    }

    @Override
    public String getGrowth() {
        return super.growthStage;
    }

    @Override
    public double getWaterRequirement() {
        return super.waterRequirement;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setHealth(String health) {
        super.health = health;
    }
}
