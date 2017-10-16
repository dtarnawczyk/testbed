package functionalProgramming.functionalInterface;

public class RecursionTests {

    public static Function<Long, Long> power;

    static {
        power = n -> n <= 1 ? n : n * power.apply(n -1);
    }

    public static void main(String[] args) {

        System.out.println(power.apply(20L));
    }
}
