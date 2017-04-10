package patterns.creator.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        Director manager = new Director();
        Builder builder = new TrainBuilder();
        manager.setBuilder(builder);
        Train train = manager.getTrain();
        //...
    }
}
