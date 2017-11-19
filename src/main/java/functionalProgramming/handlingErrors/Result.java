package functionalProgramming.handlingErrors;

import functionalProgramming.flowControl.Supplier;

import java.io.Serializable;
import java.util.function.Function;

public abstract class Result<V> implements Serializable {
    private Result(){}

    public abstract V getOrElse(final V defaultValue);
    public abstract V getOrElse(final Supplier<V> defaultValue);
    public abstract <U> Result<U> map(Function<V, U> f);
    public abstract <U> Result<U> flatMap(Function<V, Result<U>> f);

    private static class Failure<V> extends Result<V>{

        private final RuntimeException exception;

        private Failure(String message){
            super();
            this.exception = new IllegalStateException(message);
        }

        private Failure(RuntimeException exception){
            super();
            this.exception = exception;
        }

        private Failure(Exception exception){
            super();
            this.exception = new IllegalStateException(exception);
        }

        @Override
        public String toString(){
            return String.format("Failure(%s)", exception.getMessage());
        }

        @Override
        public V getOrElse(V defaultValue) {
            return defaultValue;
        }

        @Override
        public V getOrElse(Supplier<V> defaultValue) {
            return defaultValue.get();
        }

        @Override
        public <U> Result<U> map(Function<V, U> f) {
            return failure(exception);
        }

        @Override
        public <U> Result<U> flatMap(Function<V, Result<U>> f) {
            return failure(exception);
        }
    }

    private static class Success<V> extends Result<V>{

        private final V value;

        private Success(V value){
            super();
            this.value = value;
        }

        @Override
        public String toString(){
            return String.format("Success(%s)", value.toString());
        }

        @Override
        public V getOrElse(V defaultValue) {
            return defaultValue;
        }

        @Override
        public V getOrElse(Supplier<V> defaultValue) {
            return value;
        }

        @Override
        public <U> Result<U> map(Function<V, U> f) {
            try {
                return success(f.apply(value));
            } catch (Exception ex){
                return failure(ex.getMessage());
            }
        }

        @Override
        public <U> Result<U> flatMap(Function<V, Result<U>> f) {
            try {
                return f.apply(value);
            } catch (Exception ex){
                return failure(ex.getMessage());
            }
        }
    }

    public static <V,U> Result<V> failure(Failure<U> failure){
        return new Failure<V>(failure.exception);
    }

    public static <V> Result<V> failure(String message){
        return new Failure<V>(message);
    }

    public static <V> Result<V> failure(Exception ex){
        return new Failure<V>(ex);
    }

    public static <V> Result<V> failure(RuntimeException ex){
        return new Failure<V>(ex);
    }

    public static <V> Result<V> success(V value) {
        return new Success<>(value);
    }

    public Result <V> orElse(Supplier<Result<V>> defaultValue) {
        return map(x -> this).getOrElse(defaultValue);
    }
}
