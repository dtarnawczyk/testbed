import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Decoder {
    public static void main(String[] args) {

        String music1 = "1,3-5,7-11,14,15,17-20,0-4/2, 5, 7-9,0-20/4";
        String music2 = "1,2*5";

        String music3 = "0-20/4";
        String music4 = "-2*2";
//        String music5 = "130,42,5-2,46-40/2,98-89/3,11-14,196,173,107,162,23,25,117,114,83-81,27,64-76/3,178";
        String music5 = "98-89/3";
        String music6 = "89-98/3";
        String music7 = "1--5/2";
        System.out.println(Arrays.toString(uncompress(music7)));
    }

    @Test
    public void basicTests() {
        test("2 identical numbers",new int[] {1,2,2,3},"1,2*2,3");
        test("3 consecutive numbers, ascending",new int[] {1,3,4,5,7},"1,3-5,7");
        test("3 consecutive numbers, descending",new int[] {1,5,4,3,7},"1,5-3,7");
        test("3 numbers with same interval, descending",new int[] {1,10,8,6,7},"1,10-6/2,7");
    }

    private void test(String description,int[] raw,String encoded) {
        System.out.println(encoded);
        assertArrayEquals(description,raw,new Decoder().uncompress(encoded));
    }

    public static int[] uncompress(final String music) {
        if(music.length() == 0) return new int[]{};
        String[] inputs = music.split(",");
        String patternOne = "[-]?\\d+[*][-]?\\d+";
        String patternTwo = "[-]?\\d+[-][-]?\\d+";
        String patternThree = "[-]?\\d+[-][-]?\\d+[/]\\d+";
        List<Integer> decodedValues = new ArrayList<>();
        for (String input : inputs) {
            input = input.trim();
            if (input.matches(patternOne)) {
                String[] numbers = input.trim().split("[*]");
                int number = Integer.parseInt(numbers[0]);
                int count = Integer.parseInt(numbers[1]);
                for (int i = 0; i < count; i++) {
                    decodedValues.add(number);
                }
            } else if (input.matches(patternTwo)) {
                String[] numbers = input.trim().split("[-]");
                int start = Integer.parseInt(numbers[0]);
                int end = Integer.parseInt(numbers[1]);
                if(start < end) {
                    for (int i = start; i <= end; i++) {
                        decodedValues.add(i);
                    }
                } else {
                    for (int i = start; i >= end; i--) {
                        decodedValues.add(i);
                    }
                }
            } else if (input.matches(patternThree)) {
                int index = input.trim().indexOf("-");
                String firstNumStr = input.trim().substring(0, index);
                String secondPartStr = input.trim().substring(index+1);

                String[] numbers = input.trim().split("[-]");
//                int first = Integer.parseInt(numbers[0]);
                int first = Integer.parseInt(firstNumStr);


//                String[] lastAndInterval = numbers[1].split("[/]");
                String[] lastAndInterval = secondPartStr.split("[/]");

                int last = Integer.parseInt(lastAndInterval[0]);
                int interval = Integer.parseInt(lastAndInterval[1]);
                if(first < last){
                    int counter = 0;
                    decodedValues.add(first);
                    for (int i = first+1; i <= last; i++) {
                        counter += 1;
                        if(counter == interval) {
                            decodedValues.add(i);
                            counter = 0;
                        }
                    }
                } else {
                    int counter = 0;
                    decodedValues.add(first);
                    for (int i = first-1; i >= last; i--) {
                        counter += 1;
                        if(counter == interval) {
                            decodedValues.add(i);
                            counter = 0;
                        }
                    }
                }
            } else {
                decodedValues.add(Integer.parseInt(input.trim()));
            }
        }
        return  decodedValues.stream().mapToInt(Integer::intValue).toArray();
    }
}
