import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        int max = Arrays.stream(height).max().getAsInt();
        System.out.print(Arrays.stream(height).filter(i -> i == max).count());
    }
}
