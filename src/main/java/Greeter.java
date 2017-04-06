import java.util.Arrays;
import java.util.stream.IntStream;

public class Greeter implements Runnable{

    private int n = 0;
    private String target = "";

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        IntStream.range(0,n).forEach(i-> System.out.printf("Witaj, %s%n", target));
    }

    public static void main(String [] args) {
        Runnable taskOne = new Greeter(100, "Tomek");
        Runnable taskTwo = new Greeter(100, "Bartek");

        runTogether(taskOne, taskTwo);
        runInOrder(taskOne, taskTwo);

    }

    public static void runTogether(Runnable... tasks) {
        for(Runnable task : tasks){
            new Thread(task).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        Arrays.stream(tasks).parallel().forEach(t-> {
            Thread thread = new Thread(t);
            thread.start();
        });
    }
}
