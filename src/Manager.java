import java.util.ArrayList;

public class Manager {
    ArrayList<Livestock> livestock = new ArrayList<>();
    ArrayList<Crops> crops = new ArrayList<>();

    public void addLivestock(Livestock livestock) {
        this.livestock.add(livestock);
    }

    public void addCrops(Crops crops) {
        this.crops.add(crops);
    }

    public ArrayList<Livestock> getLivestock() {
        return livestock;
    }

    public ArrayList<Crops> getCrops() {
        return crops;
    }
}