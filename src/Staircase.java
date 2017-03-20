import java.util.Arrays;
import java.util.Scanner;

public class Staircase {

    public static void main(String [] args) {
        Scanner sr = new Scanner(System.in);
        try {
            int N = Integer.parseInt(sr.nextLine());
            sr.close();
            if(N > 0){
                char [] chars = new char[N];
                Arrays.fill(chars, '#');
                String step = new String(chars);
                String format = "%"+N+"s";
                for(int i = N; i > 0 ; i--){
                    System.out.println(String.format(format, step.substring(0, (N+1)-i)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
