import java.util.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        in.close();

        List<int[]> list = new ArrayList<>(3);
        list.add(h1);
        list.add(h2);
        list.add(h3);

        while(true) {
            int h1Sum = getSumFromArray(list.get(0));
            int h2Sum = getSumFromArray(list.get(1));
            int h3Sum = getSumFromArray(list.get(2));
            if(h1Sum == h2Sum && h2Sum == h3Sum){
                break;
            }
            int highestId=0;
            int highestSum = getSumFromArray(list.get(0));
            for(int i=1; i < list.size(); i++){
                int height = getSumFromArray(list.get(i));
                if(height > highestSum) {
                    highestId=i;
                    highestSum = height;
                }
            }
            int [] highestArray = list.get(highestId);
            int [] newArray = new int [highestArray.length-1];
            for(int i=1; i < highestArray.length; i++)
                newArray[i-1] = highestArray[i];
            list.set(highestId, newArray);
        }
        System.out.println(getSumFromArray(list.get(0)));

/* // Works but too long
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new ArrayDeque<>();
        for(int i= h1.length-1; i >=0; i--) stack1.push(h1[i]);
        for(int i= h2.length-1; i >=0; i--) stack2.push(h2[i]);
        for(int i= h3.length-1; i >=0; i--) stack3.push(h3[i]);
        List<Deque<Integer>> stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);

        while(true) {

            // check if all are equal
            int sum1 = stack1.stream().mapToInt(i -> i).sum();
            int sum2 = stack2.stream().mapToInt(i -> i).sum();
            int sum3 = stack3.stream().mapToInt(i -> i).sum();
            if(sum1 == sum2 && sum2 == sum3) {
                break;
            }
            // get highest stack and its id
            int id = 0;
            int highest = stack1.stream().mapToInt(i -> i).sum();
            for(int i=1; i < stacks.size(); i++){
                int height = stacks.get(i).stream().mapToInt(s -> s).sum();
                if(height > highest) {
                    id=i;
                    highest = height;
                }
            }
            // pop from the highest
            stacks.get(id).pop();
        }
        System.out.println(stack1.stream().mapToInt(i->i).sum());
    */
    }

    private static int getSumFromArray(int [] array){
        int sum = 0;
        for(int a : array){
            sum+=a;
        }
        return sum;
    }
}
