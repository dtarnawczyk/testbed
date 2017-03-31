import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Scramblies {

    public static void main(String [] args){
        System.out.println(scramble("rkqodlw","world")); //true;
        System.out.println(scramble("cedewaraaossoqqyt","codewars")); //true;
        System.out.println(scramble("katas","steak")); //false;
        System.out.println(scramble("scriptjavx","javascript")); //false;
        System.out.println(scramble("scriptingjava","javascript")); //true;
        System.out.println(scramble("scriptsjava","javascripts")); //true;
        System.out.println(scramble("javscripts","javascript")); //false;
        System.out.println(scramble("aabbcamaomsccdd","commas")); //true;
        System.out.println(scramble("commas","commas")); //true;
        System.out.println(scramble("sammoc","commas")); //true;
    }

    public static boolean scramble(String str1, String str2) {
        List<Character> str1Chars = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> str2Chars = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for(Iterator<Character> str2It = str2Chars.iterator(); str2It.hasNext();) {
            char str2char = str2It.next();
            for(Iterator<Character> str1It = str1Chars.iterator(); str1It.hasNext();) {
                char str1char = str1It.next();
                if(str2char == str1char) {
                    str1It.remove();
                    str2It.remove();
                    break;
                }
            }
        }
        return str2Chars.size() <= 0;
    }
}
