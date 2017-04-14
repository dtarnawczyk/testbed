package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw(String fillColor) {
        for (Shape shape : shapes) {
            shape.draw(fillColor);
        }
    }
}
