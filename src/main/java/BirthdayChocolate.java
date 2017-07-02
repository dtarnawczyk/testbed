import java.util.Scanner;

public class BirthdayChocolate {

    static int solve(int n, int[] s, int d, int m){
        int numberOfWays = 0;
        for(int i=0; i < n; i++) {
            int counter = m;
            int sum = 0;
            while(counter > 0){
                int index = (counter-1) + i;
                if(index >= n) break;
                sum += s[index];
                if(sum > d) break;
                counter -= 1;
                if(counter == 0 && sum == d) {
                    numberOfWays += 1;
                }
            }
        }
        return numberOfWays;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }

}
