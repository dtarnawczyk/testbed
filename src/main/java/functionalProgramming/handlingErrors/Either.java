package functionalProgramming.handlingErrors;

public abstract class Either<T, U> {

    private static class Left<T, U> extends Either<T, U> {

        private final T value;

        private Left(T value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Left(%s)", value);
        }
    }

    private static class Right<T, U> extends Either<T, U> {

        private final T value;

        private Right(T value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Right(%s)", value);
        }
    }

    public static <T, U> Either<T, U> left(T value){
        return new Left<>(value);
    }

    public static <T, U> Either<T, U> right(T value){
        return new Right<>(value);
    }

}
