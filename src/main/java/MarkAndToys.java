import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    private static int maxToys = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] inputParams = input.split("\\s");
        int toysCount = Integer.parseInt(inputParams[0]);
        int maxAmount = Integer.parseInt(inputParams[1]);
        int [] toysPrices = new int [toysCount];
        for(int i =0; i < toysCount; i++){
            toysPrices[i] = sc.nextInt();
        }
        Arrays.sort(toysPrices);
        int sum = 0;
        int toys = 0;
        for(int i=0; i < toysPrices.length; i++){
            sum += toysPrices[i];
            if(sum > maxAmount){
                break;
            } else {
                toys += 1;
            }
        }
//        generate(toysPrices, toysPrices.length-1, maxAmount);
        System.out.println(toys);
    }

    private static void generate(int [] array, int m, int maxAmount){
        if(m == 0) {
            int sum = 0;
            int toys = 0;
            for(int i=0; i < array.length; i++){
                sum += array[i];
                if(sum > maxAmount){
                    break;
                } else {
                    toys += 1;
                }
            }
            if(toys > maxToys) {
                maxToys = toys;
            }
        } else {
            for(int i=0; i <= m; i++) {
                generate(array, m-1, maxAmount);
                if(i < m) {
                    reverse(array, m-1);
                    swap(array, i, m);
                }
            }
        }
    }

    public static void reverse(int [] array, int m){
        int n = m;
        int i = 0;
        while(i < n){
            swap(array, i, n);
            i++;
            n--;
        }
    }

    private static void swap(int [] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
