import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FlamesGame {

    public static String showRelationship(String male, String female) {

        List<String> acronyms = Arrays.asList("Friendship", "Love", "Affection", "Marriage", "Enemies", "Siblings");
        Set<Character> toDelete = new HashSet<>();
        for(int i = 0; i < male.length(); i++) {
            char maleChar = male.charAt(i);
            for(int j = 0; j < female.length(); j++) {
                    char femaleChar = female.charAt(j);
                    if(maleChar == femaleChar) {
                        toDelete.add(maleChar);
                    }
            }
        }
        for(Character character : toDelete){
            male = male.replaceAll(String.valueOf(character), "");
            female = female.replaceAll(String.valueOf(character), "");
        }
        // OR:
        // final String crossMale = male.replaceAll('[' + female + ']', "");
        // final String crossFemale = female.replaceAll('[' + male + ']', "");
        int length = male.length()+female.length();
        return length == 0 ? acronyms.get(0) : acronyms.get((length-1) % acronyms.size());
    }

    @Test
    public void testSimpleFlames() throws Exception {
//        assertEquals("NEIL and MAE are enemies" ,
//                "Enemies", FlamesGame.showRelationship("NEIL", "MAE"));
        assertEquals("BRODERICK and VALENTINE are friends" ,
                "Friendship", FlamesGame.showRelationship("BRODERICK", "VALENTINE"));
    }

}
