import java.util.*;
import java.util.stream.Collectors;

public class Palindrome {

    public static int differentingIndexOfPallindrome(String input) {
        List<Character> list = input.trim().chars()
                .mapToObj(c -> (char)c).collect(Collectors.toList());
        List<Character> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        for(int i=0; i < list.size(); i++) {
            if(list.get(i) != reversed.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public  static int palindromeIndex(String input) {
        if(isPalliandrom(input)) {
            return -1;
        }
        int removedIndex = 0;
        for(int i=0; i < input.length(); i++) {
            String start = input.substring(0, i);
            String end = input.substring(i+1);
            String in = start + end;

            if(isPalliandrom(in)) {
                removedIndex = i;
                break;
            }
        }
        return removedIndex;
    }
    private static boolean isPalliandrom(String input){
//        List<Character> list = input.trim().chars()
//                .mapToObj(c -> (char)c).collect(Collectors.toList());
//        List<Character> reversed = new ArrayList<>(list);
//        Collections.reverse(reversed);
//        for(int i=0; i < list.size(); i++) {
//            if(list.get(i) != reversed.get(i)) return false;
//        }

        char [] inputChars = input.trim().toCharArray();
        for(int i=0; i < inputChars.length/2; i++){
            for(int j= inputChars.length-1; j >= inputChars.length/2; j--) {
                if(inputChars[i] != inputChars[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String [] strings = new String [n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        in.close();
        for (int i = 0; i < n; i++) {
            System.out.println(palindromeIndex(strings[i]));
        }

    }

}
