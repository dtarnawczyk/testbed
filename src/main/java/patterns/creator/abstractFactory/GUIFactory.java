package patterns.creator.abstractFactory;

public class GUIFactory {

    public static Button createButton(String type) {
        switch (type) {
            case "windows" : {
                return new WindowsButtonFactory().createButton();
            }
            case "macOs" : {
                return new MacOsButtonFactory().createButton();
            }
            default: {
            }
        }
        return null;
    }
}
