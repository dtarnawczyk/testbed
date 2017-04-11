package patterns.creator.prototype;

import java.util.HashMap;
import java.util.Map;

public class ColorStore {

    private static Map<String, Color> colorMap = new HashMap<String, Color>();

    static {
        colorMap.put("red", new Red());
        colorMap.put("green", new Green());
    }

    public static Color getColor(String colorName){
        return (Color) colorMap.get(colorName).clone();
    }
}
