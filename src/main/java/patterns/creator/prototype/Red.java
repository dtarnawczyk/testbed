package patterns.creator.prototype;

public class Red extends Color {

    public Red(){
        this.name = "RED";
    }
    @Override
    public void fillColor() {
        System.out.println("Filling with "+this.name);
    }
}
