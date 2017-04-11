package patterns.creator.abstractFactory;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}
