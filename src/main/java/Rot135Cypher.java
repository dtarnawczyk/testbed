import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Rot135Cypher {
    public static String ROT135(String input) {
        String [] words = input.split("\\s");
        String [] newWords = new String[words.length];
        for(int i=0; i < words.length; i++){
            char [] word = words[i].toCharArray();
            for(int j=0; j < word.length; j++){
                char letter = word[j];
                if(Character.isDigit(letter)) {
                    int number = Integer.parseInt(String.valueOf(letter));
                    number = (number + 5) % 10;
                    word[j] = Character.forDigit(number, 10);
                } else {
                    if (letter >= 'a' && letter <= 'm') letter += 13;
                    else if (letter >= 'A' && letter <= 'M') letter += 13;
                    else if (letter >= 'n' && letter <= 'z') letter -= 13;
                    else if (letter >= 'N' && letter <= 'Z') letter -= 13;
                    word[j] = letter;
                }
            }
            newWords[i] = new String(word);
        }
        return String.join(" ", newWords);
    }

    @Test
    public void testSomething() {
        assertEquals("Gur dhvpx oebja sbk whzcf bire gur ynml qbtf", Rot135Cypher.ROT135("The quick brown fox jumps over the lazy dogs"));
        assertEquals("Gur dhvpx oebja sbk whzcf bire gur 7 ynml qbtf", Rot135Cypher.ROT135("The quick brown fox jumps over the 2 lazy dogs"));
        assertEquals("The quick brown fox jumps over the 2 lazy dogs", Rot135Cypher.ROT135("Gur dhvpx oebja sbk whzcf bire gur 7 ynml qbtf"));
    }
}
