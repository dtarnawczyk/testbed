package functionalProgramming.flowControl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Doubler {
    private static Map<Integer, Integer> cache = new ConcurrentHashMap<>();
    public static Integer doubleValue(Integer x) {
        return cache.computeIfAbsent(x, y -> y * 2);
    }

    public static Function<Integer, Integer> doubleValue = x -> cache.computeIfAbsent(x, y -> y * 2);
}
