package rrdp;

import java.util.HashSet;
import java.util.Set;

public class R11 {

    public static void main(String[] args) {
        char [] chars = {'a', 'a', 'w', 'a', 'x', 'x', 'c'};
        char [] distinctChars = new char[chars.length];

        Set<Character> characterSet = new HashSet<>();
        for(char ch : chars) {
            characterSet.add(ch);
        }
    }
}
