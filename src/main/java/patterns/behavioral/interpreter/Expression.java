package patterns.behavioral.interpreter;

public interface Expression {
    String interpret(InterpreterContext ic);
}