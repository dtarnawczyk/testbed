import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EqualHackerrank {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int T = Integer.valueOf(in.nextLine());

            List<int[]> listOfTestcases = new ArrayList();
            for (int i=0; i < T; i++) {
                int N = Integer.valueOf(in.nextLine());
                int [] colleaguesInitialChocolateCounts =
                        Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                listOfTestcases.add(colleaguesInitialChocolateCounts);
            }

            for(int [] array : listOfTestcases) {
                System.out.println(getMinimalSteps(array));
            }


        }

        public static int getMinimalSteps(int [] arrayOfChockolates) {
            int operationOneChocolates = 1;
            int operationTwoChocolates = 3;
            int operationThreeChocolates = 5;

            int stepCounter = 0;
            while (true) {

                if (Arrays.stream(arrayOfChockolates).allMatch(i -> i == arrayOfChockolates[0]) ) {
                    return stepCounter;
                } else {





                }

            }
        }


}
