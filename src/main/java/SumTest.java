import java.util.Arrays;
import java.util.List;

/**
 * Created by dominik on 2017-02-11.
 */
public class SumTest {

    private static List<Node> nodes = Arrays.asList(
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false),
            new Node(5, 4, false, false)
    );


    public static void main(String [] args) {
//        System.out.println(12 / 20);
//        System.out.println(24 / 20);
//        System.out.println(15 / 30);
//        System.out.println(30 / 30);
//        System.out.println(60 / 20);


//            int numbers = users.stream().mapToInt(u -> u.number).sum();
//            for(int i : numbers){
//                System.out.println(i);
//            }

            int sum = 76;
            int tmp = 0;
            boolean isEnought = false;
            for(Node n : nodes) {
                tmp += n.cpus;
                int div = tmp / sum;
                if (div <= 1) {
                    n.selected = true;
                }
                if (div >= 1) {
                    isEnought = true;
                    break;
                }
            }

            System.out.println(nodes.stream().filter(n -> n.selected ).count());
            System.out.println(isEnought);
//            for(Node n : nodes){
//
//                System.out.println(n);
//            }
//
//            System.out.println();

    }


    private static class Node {
        public int cpus;
        public int freeCpus;
        public boolean selected;
        public boolean rejected;
        public Node(int cpus, int freeCpus, boolean selected, boolean rejected){
            this.cpus = cpus;
            this.freeCpus =  freeCpus;
            this.selected = selected;
            this.rejected = rejected;
        }
    }
}
