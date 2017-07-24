import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortTwisted37 {

    public static void main(String[] args) {
        sortTwisted37(new Integer[] {123377});
    }

    // BEST PRACTICE:
//    private static Integer swap37(Integer i) {
//        return Integer.valueOf(i.toString()
//                .replace("7", "_")
//                .replace("3", "7")
//                .replace("_", "3")
//        );
//    }
//
//    public static Integer[] sortTwisted37(Integer[] array)
//    {
//        return Arrays.stream(array)
//                .map(SortTwisted37::swap37)
//                .sorted(Integer::compare)
//                .map(SortTwisted37::swap37)
//                .toArray(Integer[]::new);
//    }

    public static Integer[] sortTwisted37(Integer[] array) {
        Integer [] outputArray = Arrays.copyOf(array, array.length);

        for(int i = 0; i < outputArray.length; i++) {
            String output = Integer.toString(outputArray[i]);
            char [] chars = output.toCharArray();
            for(int j=0; j < chars.length; j++){
                if(chars[j] == '3'){
                    chars[j] = '7';
                } else if(chars[j] == '7'){
                    chars[j] = '3';
                }
            }
            outputArray[i] = Integer.parseInt(new String(chars));
        }
        Arrays.sort(outputArray);
        for(int i = 0; i < outputArray.length; i++) {
            String output = Integer.toString(outputArray[i]);
            char [] chars = output.toCharArray();
            for(int j=0; j < chars.length; j++){
                if(chars[j] == '7'){
                    chars[j] = '3';
                } else if(chars[j] == '3'){
                    chars[j] = '7';
                }
            }
            outputArray[i] = Integer.parseInt(new String(chars));
        }
        return outputArray;
    }

    @Test
    public void basicTests() {
        assertEquals(Arrays.toString(new Integer[] {1,2,7,4,5,6,3,8,9}), Arrays.toString(SortTwisted37.sortTwisted37(new Integer[] {1,2,3,4,5,6,7,8,9})));
        assertEquals(Arrays.toString(new Integer[] {12,14,13}), Arrays.toString(SortTwisted37.sortTwisted37(new Integer[] {12,13,14})));
        assertEquals(Arrays.toString(new Integer[] {2,7,4,3,9}), Arrays.toString(SortTwisted37.sortTwisted37(new Integer[] {9,2,4,7,3})));
    }
}
