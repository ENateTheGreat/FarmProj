import java.util.Random;

public class LivestockProductionManager {
    private int randomizer() {
        Random random = new Random();
        int rand = random.nextInt(21);
        return rand;
    }

    public int today = randomizer();
    public int yesterday = randomizer();
    public Livestock livestock;

    public LivestockProductionManager(Livestock livestock) {this.livestock = livestock;}

    private double getProductionRatio() {
        if (this.today > this.yesterday) {
            return (((double) this.yesterday /this.today)*100);
        } else if (this.today < this.yesterday) {
            return (((double) this.today /this.yesterday)*100);
        }  else {
            System.out.println("Production is the same today compared to yesterday.");
            return 0;
        }
    }

    public void checkProduction() {
        if (this.today > this.yesterday) {
            System.out.println("Production increased by " + getProductionRatio()
            + " percent compared to yesterday by " + livestock.getAnimalName() + ".");
        } else if (this.today < this.yesterday) {
            System.out.println("Production increased by " + getProductionRatio()
                    + " percent compared to yesterday for " + livestock.getAnimalName() + ".");
        }  else {
            System.out.println("Production is the same today compared to yesterday for " + livestock.getAnimalName() + ".");
        }
    }
}