import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pangrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.replaceAll(" ","");
        input = input.toLowerCase();
        char [] array = input.toCharArray();
        Set<Character> set = IntStream.range(0, array.length)
                .mapToObj(i ->
                        array[i])
                .collect(
                        Collectors.toSet());
        if(set.size() == 26){
            System.out.print("pangram");
        } else {
            System.out.print("not pangram");
        }

    }

}
