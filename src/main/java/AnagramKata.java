import java.util.Arrays;
public class AnagramKata {

    public static void main(String[] args) {

        String str1 = "anagram sddf";
        String str2 = "naramga dsfd";

        char [] chars1 = str1.toCharArray();
        char [] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        System.out.println("Are anagrams: " + Arrays.equals(chars1, chars2));

    }
}
