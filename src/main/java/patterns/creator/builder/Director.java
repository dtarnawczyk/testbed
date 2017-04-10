package patterns.creator.builder;


public class Director {
    private Builder builder;

    public void setBuilder(Builder builder){
        this.builder = builder;
    }

    public Train getTrain() {
        return this.builder.buildTrain();
    }
}
