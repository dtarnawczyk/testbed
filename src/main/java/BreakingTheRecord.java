import java.util.Scanner;

public class BreakingTheRecord {


    static int[] getRecord(int[] s) {
        int min = s[0];
        int max = s[0];
        int upCounter = 0;
        int downCounter = 0;

        for(int i = 1; i < s.length; i++){
            if(s[i] < min){
                min = s[i];
                downCounter += 1;
            }
            if(s[i] > max) {
                max = s[i];
                upCounter += 1;
            }
        }
        return new int [] {upCounter, downCounter};
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
