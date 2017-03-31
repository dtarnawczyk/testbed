import java.util.Arrays;
import java.util.Scanner;

public class SparseArray {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String [] stringsArray = new String[N];
        for (int i = 0; i < N; i++) {
            stringsArray[i] = sc.nextLine();
        }
        int Q = Integer.parseInt(sc.nextLine());
        String [] queriesArray = new String[Q];
        for (int i = 0; i < Q; i++) {
            queriesArray[i] = sc.nextLine();
        }
        sc.close();
        for(String queryString : queriesArray){
            System.out.println(
                    Arrays.stream(stringsArray)
                            .filter(s -> s.equals(queryString)).count());

        }
    }
}
