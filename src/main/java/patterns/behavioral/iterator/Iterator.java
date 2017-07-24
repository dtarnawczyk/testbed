package patterns.behavioral.iterator;

public interface Iterator<I extends Number> {
    boolean hasNext();
    Object next();
}
