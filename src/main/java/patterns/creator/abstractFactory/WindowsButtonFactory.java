package patterns.creator.abstractFactory;

public class WindowsButtonFactory implements ButtonFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
