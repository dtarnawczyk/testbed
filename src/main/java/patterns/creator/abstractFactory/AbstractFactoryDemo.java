package patterns.creator.abstractFactory;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        Button btn = GUIFactory.createButton("windows");
        btn.paint();
        btn = GUIFactory.createButton("macOs");
        btn.paint();
    }
}
