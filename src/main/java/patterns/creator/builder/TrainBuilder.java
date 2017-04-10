package patterns.creator.builder;

public class TrainBuilder implements Builder{

    private Train train;

    public TrainBuilder(){
    }

    @Override
    public Train buildTrain() {
        train = new CargoTrain();
        train.setCarriages(5);
        train.setLocomotive("BIG");
        return train;
    }
}
