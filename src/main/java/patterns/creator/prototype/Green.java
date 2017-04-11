package patterns.creator.prototype;

public class Green extends Color {

    public Green(){
        this.name = "GREEN";
    }

    @Override
    public void fillColor() {
        System.out.println("Filling with "+this.name);
    }
}
