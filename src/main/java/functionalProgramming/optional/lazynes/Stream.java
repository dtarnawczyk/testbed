package functionalProgramming.optional.lazynes;

import java.util.function.Supplier;

public abstract class Stream<A> {

    private static Stream EMPTY = new Empty();
    public abstract A head();
    public abstract Stream<A> tail();
    public abstract Boolean isEmpty();
    private Stream(){}

    private static class Empty<A> extends Stream<A> {

        @Override
        public A head() {
            throw new IllegalStateException("head() for an empty list");
        }

            @Override
        public Stream<A> tail() {
            throw new IllegalStateException("tail() for an empty list");
        }

        @Override
        public Boolean isEmpty() {
            return true;
        }
    }

    private static class Const<A> extends Stream<A> {

        private final Supplier<A> head;
        private A h;
        private final Supplier<Stream<A>> tail;
        private Stream<A> t;

        public Const(Supplier<A> head, Supplier<Stream<A>> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public A head() {
            if(h == null)
                h = head.get();
            return h;
        }

        @Override
        public Stream<A> tail() {
            if(t == null)
                t = tail.get();
            return t;
        }

        @Override
        public Boolean isEmpty() {
            return false;
        }
    }

    static <A> Stream<A> cons(Supplier<A> head, Supplier<Stream<A>> tail){
        return new Const<>(head, tail);
    }

    static <A> Stream <A> cons(Supplier<A> head, Stream<A> tail){
        return new Const<>(head, () -> tail);
    }

    @SuppressWarnings("unchecked")
    public static <A> Stream<A> empty(){
        return EMPTY;
    }

    public static Stream<Integer> from(int i) {
        return cons(() -> i, () -> from(i+1));
    }

}
