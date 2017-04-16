package patterns.structural.flyweight;

import java.util.concurrent.ThreadLocalRandom;

public class FlyweightDemo {

    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }

    }

    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(ThreadLocalRandom.current().ints().findFirst().getAsInt()*100 );
    }
    private static int getRandomY() {
        return (int)(ThreadLocalRandom.current().ints().findFirst().getAsInt()*100);
    }
}

