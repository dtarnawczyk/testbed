package functionalProgramming.optional;

public abstract class Option<A> {
    @SuppressWarnings("rawtypes")
    private static Option none = new None();
    public abstract A getOrThrow();

    private static class None<A> extends Option<A> {
        private None(){}

        @Override
        public A getOrThrow() {
            throw new IllegalStateException("get użyte dla None");
        }

        @Override
        public String toString(){
            return "None";
        }
    }

    private static class Some<A> extends Option<A> {
        private final A value;

        private Some(A a){
            this.value = a;
        }

        @Override
        public A getOrThrow() {
            return value;
        }

        @Override
        public String toString(){
            return String.format("Some(%s)", this.value);
        }
    }

    public static <A> Option<A> some(A a){
        return new Some<>(a);
    }

    @SuppressWarnings("rawtypes")
    public static <A> Option<A> none(){
        return none;
    }

}
