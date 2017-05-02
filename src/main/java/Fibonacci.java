import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String [] args) {

        System.out.println(fibonacci(100));

    }

    public static List<Integer> fibonacci(int range) {

        int first = 0;
        int second = 1;
        List<Integer> fibs = new ArrayList<>();
        fibs.add(second);
        for(int i=0; i < range; i++){
            fibs.add(first + second);
            first = second;
            second = first + second;
        }
        return fibs;

    }
}
