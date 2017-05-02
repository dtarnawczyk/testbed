import java.util.Scanner;

public class MarcsCakewalk {

    private static int mils = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calories = new int[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        generatePermutations(n, calories);
        System.out.println("mils: "+ mils);
    }

    static void generatePermutations(int n, int [] array) {
        if (n == 1) {
//            System.out.println(Arrays.toString(array));
            int sum = 0;
            for(int i=0; i < array.length; i++){
                sum += array[i] * Math.pow(2, i);
            }
//            System.out.println(sum);
            if(sum < mils){
                mils = sum;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            generatePermutations(n - 1, array);
            if ((n & 1) == 0) {
                int tmp = array[i];
                array[i]   = array[n-1];
                array[n-1] = tmp;
            } else {
                int tmp = array[0];
                array[0]   = array[n-1];
                array[n-1] = tmp;
            }
        }
    }
}
