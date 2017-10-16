package functionalProgramming.functionalInterface;

public interface Function <T, U> {
    U apply(T arg);
}

class FunctionTest {

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return new Function<Integer, Integer>(){
            @Override
            public Integer apply(Integer arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }

    static Function<Integer, Integer> compose2(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    public static void main(String[] args) {
        Integer input = 5;
        System.out.println(getCompose(input));

        withAnonymousFunction(input);
    }

    private static Integer getCompose(Integer input) {
        return compose(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg + 15;
            }
        }, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg - 15;
            }
        }).apply(input);
    }

    public static void withAnonymousFunction(Integer input) {
        Integer output = compose(x -> x + 15, x -> x - 15).apply(input);
        System.out.println(output);
    }
}