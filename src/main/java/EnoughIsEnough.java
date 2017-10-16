import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOcurrences) {

        Map<Integer, Integer> elementOccurence = new LinkedHashMap<>();
        List<Integer> enoughtElements = new ArrayList<>();
        for(int i : elements){
            if(elementOccurence.containsKey(i)){
                elementOccurence.replace(i, elementOccurence.get(i)+1);
            } else {
                elementOccurence.put(i, 1);
            }

            if(elementOccurence.get(i) <= maxOcurrences) {
                enoughtElements.add(i);
            }
        }
        return enoughtElements.stream().mapToInt(i->i).toArray();
    }

    @Test
    public void deleteNth() throws Exception {
        assertArrayEquals(
                new int[] { 20, 37, 21 },
                EnoughIsEnough.deleteNth( new int[] { 20, 37, 20, 21 }, 1 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )

        );
        assertArrayEquals(
                new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
                EnoughIsEnough.deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 1, 1, 1 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
        );
        assertArrayEquals(
                new int[] { },
                EnoughIsEnough.deleteNth( new int[] { }, 5 )
        );

    }
}
