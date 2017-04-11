package patterns.creator.abstractFactory;

public class MacOsButtonFactory implements ButtonFactory{

    @Override
    public Button createButton() {
        return new MacOsButton();
    }
}
