import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {
    private static int lonelyInteger(int[] a) {
        if(a.length == 1) return a[0];
        Boolean [] pairedElements = new Boolean[a.length];
        Arrays.fill(pairedElements, Boolean.FALSE);
        for(int i = 0; i < a.length; i++){
            if(pairedElements[i] == false) {
                int first = a[i];
                for (int j = i+1; j < a.length; j++) {
                    if(pairedElements[j] == false) {
                        int second = a[j];
                        if (first == second) {
                            pairedElements[i] = true;
                            pairedElements[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        int i = Arrays.stream(pairedElements)
                .filter(p -> p == false)
                .mapToInt(p -> Arrays.asList(pairedElements).indexOf(p))
                .findFirst().getAsInt();
        
        return a[i];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        System.out.println(lonelyInteger(a));
    }

}
