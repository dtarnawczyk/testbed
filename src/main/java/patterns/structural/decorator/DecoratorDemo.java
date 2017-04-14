package patterns.structural.decorator;

public class DecoratorDemo {

    public static void main(String[] args) {


        Car basicCar = new BasicCar();
        basicCar.assemble();

        Car sportsCar = new SportsCar(basicCar);
        sportsCar.assemble();

        Car sportsLuxuryCar = new LuxuryCar(sportsCar);
        sportsLuxuryCar.assemble();
    }

}
