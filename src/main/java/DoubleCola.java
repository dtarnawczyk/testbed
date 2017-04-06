import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.LongStream;

public class DoubleCola {

    public static void main(String[] args) {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 6;
        //"Sheldon"
        System.out.println(whoIsNext(names, n));
    }

    public static String whoIsNext(String[] names, int n) {
        Deque<String> queue = new ArrayDeque<>();
        for(String name : names) {
            queue.push(name);
        }

        final String[] name = {""};
        LongStream.range(0,n).forEach(s -> {
            name[0] = queue.pollLast();
            queue.push(name[0]);
            queue.push(name[0]);
        });
        return name[0];
    }
}
