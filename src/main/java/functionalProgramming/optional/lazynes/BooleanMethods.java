package functionalProgramming.optional.lazynes;

import java.util.function.Supplier;

public class BooleanMethods {

    public static void main(String[] args) {
        System.out.println(getFirst() || getSecond());
        System.out.println(or(() -> getFirst(), () -> getSecond()));
    }

    private static boolean or(Supplier<Boolean> a, Supplier<Boolean> b) {
        return a.get() ? true : b.get() ? true : false;
    }

    private static boolean and(Supplier<Boolean> a, Supplier<Boolean> b) {
        return a.get() ? b.get() ? true : false : false;
    }

    private static boolean getSecond() {
        throw new IllegalStateException();
    }

    private static boolean getFirst() {
        return true;
    }


}
