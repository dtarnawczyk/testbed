import java.util.Scanner;

public class LinearSearch {

    public static void main(String [] args) {

        Scanner sr = new Scanner(System.in);
        int searchValue = Integer.parseInt(sr.nextLine());
        int N = Integer.parseInt(sr.nextLine());
        if(N > 0){
            String arrayString = sr.nextLine();
            String [] array = arrayString.split("\\s");

            int index = 0;
            for(int i = 0; i < array.length; i++){
                if (Integer.valueOf(array[i]) == searchValue) {
                   System.out.printf("%s", i);
                }
            }
        }
        sr.close();

    }
}
