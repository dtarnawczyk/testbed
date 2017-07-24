import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Shapes {

    @Test
    public void ShapesAreSortableOnArea()
    {
        // Arrange
        double area, side, radius, base, height, width;
        ArrayList<Shape> expected = new ArrayList<Shape>();

        area = 1.1234;
        expected.add(new CustomShape(area));

        side = 1.1234;
        expected.add(new Square(side));

        radius = 1.1234;
        expected.add(new Circle(radius));

        height = 2.;
        base = 5.;
        expected.add(new Triangle(base, height));

        height = 3.;
        base = 4.;
        expected.add(new Triangle(base, height));

        width = 4.;
        expected.add(new Rectangle(width, height));

        area = 16.1;
        expected.add(new CustomShape(area));

        Random random = new Random();
        ArrayList<Shape> actual = createRandomOrderedList(random, expected);

        // Act
        Collections.sort(actual);

        // Assert
        Iterator a = actual.iterator();
        for (Shape e : expected) {
            assertEquals(e, a.next());
        }
    }

    private ArrayList<Shape> createRandomOrderedList(Random random, ArrayList<Shape> expected){
        ArrayList<Shape> actual = new ArrayList<Shape>();
        for (Shape shape : expected) {
            int j = random.nextInt(actual.size()+1);
            actual.add(j, shape);
        }
        return actual;
    }
}

abstract class Shape implements Comparable<Shape> {

    protected double area;

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape o) {
        if(getArea() > o.getArea()) {
            return 1;
        } else if(getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class CustomShape extends Shape {
    CustomShape(double side){
        area = side;
    }
}

class Square extends Shape {
    Square(double side){
        area = side * side;
    }
}

class Rectangle extends Shape {
    Rectangle(double width, double height){
        area = width * height;
    }
}

class Triangle extends Shape {
    Triangle(double base, double height){
        area = (base * height) / 2;
    }
}

class Circle extends Shape {
    Circle(double radius){
        area = Math.sqrt(radius) * Math.PI;
    }
}