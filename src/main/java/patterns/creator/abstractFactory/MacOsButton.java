package patterns.creator.abstractFactory;

public class MacOsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting MacOs Button");
    }
}
