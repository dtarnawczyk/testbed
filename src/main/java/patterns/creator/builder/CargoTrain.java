package patterns.creator.builder;

public class CargoTrain implements Train {

    private int carriages = 0;
    private String locomotive = "";

    public int getCarriages() {
        return this.carriages;
    }

    public String getLocomotive() {
        return this.locomotive;
    }

    public void setCarriages(int carriages) {
        this.carriages = carriages;
    }

    public void setLocomotive(String locomotive) {
        this.locomotive = locomotive;
    }
}
