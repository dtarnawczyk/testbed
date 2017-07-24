import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VowelsAndConsonants {

    public static boolean isAlt(String word) {

        List<Character> vovels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        boolean startsFromVovel = vovels.contains(word.charAt(0));
        boolean isAlt = true;
        for(int i=0; i < word.length(); i++){
            if(startsFromVovel) {
                if(i % 2 == 0){
                    if(!vovels.contains(word.charAt(i))){
                        isAlt = false;
                        break;
                    }
                } else {
                    if(vovels.contains(word.charAt(i))){
                        isAlt = false;
                        break;
                    }
                }
            } else {
                if(i % 2 != 0){
                    if(!vovels.contains(word.charAt(i))){
                        isAlt = false;
                        break;
                    }
                } else {
                    if(vovels.contains(word.charAt(i))){
                        isAlt = false;
                        break;
                    }
                }
            }
        }
        return isAlt;
    }

    @Test
    public void exampleTests() {
        assertEquals(true, VowelsAndConsonants.isAlt("amazon"));
        assertEquals(false, VowelsAndConsonants.isAlt("apple"));
        assertEquals(true, VowelsAndConsonants.isAlt("banana"));
        assertEquals(false, VowelsAndConsonants.isAlt("fomukzbp"));
        assertEquals(false, VowelsAndConsonants.isAlt("rcinoewok"));
        assertEquals(false, VowelsAndConsonants.isAlt("uadxiruf"));
        assertEquals(false, VowelsAndConsonants.isAlt("ufowmiwy"));
        assertEquals(false, VowelsAndConsonants.isAlt("anmudagiy"));
        assertEquals(false, VowelsAndConsonants.isAlt("vhilyanb"));
        assertEquals(false, VowelsAndConsonants.isAlt("ohwaausur"));
        assertEquals(false, VowelsAndConsonants.isAlt("usutcday"));
        assertEquals(false, VowelsAndConsonants.isAlt("bjtuwieu"));
        assertEquals(false, VowelsAndConsonants.isAlt("jabao"));

    }
}
