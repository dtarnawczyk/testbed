package patterns.creator.factoryMethod;

public class FactoryMethodDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactoryImpl();
        Shape shape = factory.getShape("circle");
        shape.draw();
        shape = factory.getShape("rectangle");
        shape.draw();
    }
}
