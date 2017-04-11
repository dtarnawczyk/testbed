package patterns.creator.prototype;

public class PrototypeDemo {
    public static void main(String a[]){
        ColorStore.getColor("red").fillColor();
        ColorStore.getColor("green").fillColor();
        ColorStore.getColor("green").fillColor();
        ColorStore.getColor("red").fillColor();
    }
}