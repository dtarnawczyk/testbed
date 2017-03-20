import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class PlusMinurHR {

    public static void main(String [] args) {

//        Scanner sr = new Scanner(System.in);
//        try {
//            int N = Integer.parseInt(sr.nextLine());
//            if(N > 0){
//                String arrayString = sr.nextLine();
//                List<String> integers = Arrays.asList(arrayString.split("\\s"));
//                double negativeCount = 0;
//                double positiveCount = 0;
//                double zerosCount = 0;
//                for (String integerString : integers) {
//                    int integer = Integer.parseInt(integerString);
//                    if(integer > 0) {
//                        positiveCount ++;
//                    } else if (integer < 0) {
//                        negativeCount ++;
//                    } else {
//                        zerosCount ++;
//                    }
//                }
//                sr.close();
//                System.out.println(new BigDecimal(positiveCount / N).setScale(6, 4));
//                System.out.println(new BigDecimal(negativeCount / N).setScale(6, 4));
//                System.out.println(new BigDecimal(zerosCount / N).setScale(6, 4));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Java 8
        Scanner sr = new Scanner(System.in);
        try {
            int N = Integer.parseInt(sr.nextLine());
            if(N > 0){
                String [] stringArray = sr.nextLine().split("\\s");
                double positiveCount = Arrays.asList(
                        stringArray).stream().filter((String s) -> {
                    return Integer.parseInt(s) > 0;
                }).count();
                double negativeCount = Arrays.asList(
                        stringArray).stream().filter((String s) -> {
                    return Integer.parseInt(s) < 0;
                }).count();
                double zerosCount = Arrays.asList(
                        stringArray).stream().filter((String s) -> {
                    return Integer.parseInt(s) == 0;
                }).count();

                sr.close();
                System.out.println(new BigDecimal(positiveCount / N).setScale(6, 4));
                System.out.println(new BigDecimal(negativeCount / N).setScale(6, 4));
                System.out.println(new BigDecimal(zerosCount / N).setScale(6, 4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
