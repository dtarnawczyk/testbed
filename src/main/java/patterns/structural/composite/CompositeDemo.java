package patterns.structural.composite;

public class CompositeDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape triangle = new Triangle();

        Drawing drawing = new Drawing();
        drawing.addShape(circle);
        drawing.addShape(triangle);

        Shape draw = (Shape) drawing;

        circle.draw("red");
        triangle.draw("blue");
        draw.draw("yellow");

    }

}
