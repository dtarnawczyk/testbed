import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        for(int i=0; i < q; i++){
            String [] params = sc.nextLine().split("\\s");
            if(params.length > 1) {
                int param = Integer.valueOf(params[1]);
                while (!secondStack.isEmpty()){
                    firstStack.push(secondStack.pop());
                }
                firstStack.push(param);
                secondStack.removeAllElements();
                while (!firstStack.isEmpty()){
                    secondStack.push(firstStack.pop());
                }
            } else {
                if(Integer.valueOf(params[0]) == 2){
                    if(!secondStack.isEmpty()) {
                        while (!firstStack.isEmpty()) {
                            secondStack.push(firstStack.pop());
                        }

                        secondStack.pop();
                        firstStack.removeAllElements();
                        while (!secondStack.isEmpty()) {
                            firstStack.push(secondStack.pop());
                        }
                    }
                } else {
                    if(!secondStack.isEmpty()) {
                        System.out.println(secondStack.peek());
                    }
                }
            }
        }
    }
}
