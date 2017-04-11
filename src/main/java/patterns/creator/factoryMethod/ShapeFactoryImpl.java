package patterns.creator.factoryMethod;

public class ShapeFactoryImpl implements ShapeFactory {
    @Override
    public Shape getShape(String type) {
        switch (type) {
            case "circle" : {
                return new Circle();
            }
            case "rectangle" : {
                return new Rectangle();
            }
            default: {
                break;
            }
        }
        return null;
    }
}
