package functionalProgramming.functionalInterface;

public interface BinaryOperator extends Function<Integer, Function<Integer, Integer>> {}

class BinaryOpertortest {
    public static void main(String[] args) {
        /*
          1. BinaryOperator
         */
        BinaryOperator add = new BinaryOperator() {
            @Override
            public Function<Integer, Integer> apply(Integer arg1) {
                return new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer arg2) {
                        return arg1 + arg2;
                    }
                };
            }
        };

        System.out.println(add.apply(3).apply(4));

        // Short version of 'add'
        BinaryOperator add2 = x -> y -> x+y;
        System.out.println(add2.apply(5).apply(10));

        /*
          2. Square and triple
         */
        Function<Function<Integer, Integer>,
                Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> compose = x -> y -> z -> x.apply(y.apply(z));

        Function<Integer, Integer> triple = x -> x*3;
        Function<Integer, Integer> square = x -> x*x;
        Function<Integer, Integer> function = compose.apply(square).apply(triple);
        System.out.println(function.apply(2));

        /*
         * 3. Polymorphic 'compose'
         */
        Integer output = BinaryOpertortest.<Integer, Integer, Integer>higherCompose().apply(square).apply(triple).apply(2);
        System.out.println(output);


        /*
         * 4.
         */
        String output2 = BinaryOpertortest.<String, String, String, String>fun().apply("one").apply("two").apply("three").apply("four");
        System.out.println(output2);
    }

    static <T, U, V> Function<Function<U, V>,
                     Function<Function<T, U>,
                              Function<T, V>>> higherCompose(){
        return f -> g -> x -> f.apply(g.apply(x));
    }

    static <A, B, C, D> String func(A a, B b, C c, D d){
        return String.format("%s, %s, %s, %s", a, b, c, d);
    }

    static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> fun(){
        return a -> b -> c -> d -> String.format("%s, %s, %s, %s", a, b, c, d);
    }
}