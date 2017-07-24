import java.util.*;

public class MaximumElement {
    public static void main(String [] args ) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Deque<Long> stack = new ArrayDeque<>();
        List<Long> maxes = new ArrayList<>();
        for(short i=0; i < N; i++) {
            String [] inputArray = scanner.nextLine().split(" ");
            int queue = Integer.parseInt(inputArray[0]);
            switch (queue) {
                case 1: {
                    long value = Long.parseLong(inputArray[1]);
                    stack.push(value);
                    break;
                }
                case 2: {
                    stack.poll();
                    break;
                }
                default: {
                    long m = stack.peek();
                    for(long v : stack){
                        if(v > m) m = v;
                    }
                    maxes.add(m);
                }
            }
        }
        scanner.close();
        maxes.forEach(i -> System.out.println(i));
    }


}
