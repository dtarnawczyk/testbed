package patterns.structural.composite;

public class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle in: " + fillColor);
    }
}
