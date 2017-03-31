import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class BookJava8Chapter1{


    public static void main(String [] args) {
        int input = -88;
//        System.out.printf("%s%n", showBinary(input));
//        System.out.printf("%s%n", showOctal(input));
//        System.out.printf("%s%n", showHexadecimal(input));
//        System.out.printf("%d%n", normalize(input));
//        maxDouble();
//        System.out.printf("%s", factorial(1000));
//        System.out.printf("%d%n", randomFrom1to49());
        trianglePascal(10);
    }

    public static String showBinary(int input){
        return Integer.toBinaryString(input);
    }

    public static String showOctal(int input){
        return Integer.toOctalString(input);
    }

    public static String showHexadecimal(int input){
        return Integer.toHexString(input);
    }

    public static int normalize(int input){
        return Math.floorMod(input, 359);
    }

    public static void maxDouble(){
        System.out.printf("%f%n", Double.MAX_VALUE);
        System.out.printf("%f%n", Double.MIN_VALUE);
        System.out.printf("%f%n", Math.nextUp(Double.MAX_VALUE));
    }

    public static String factorial(int input) {

        BigInteger factorial = BigInteger.ONE;
        for(int i=1; i <= input; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial.toString();
    }

    public static int randomFrom1to49() {
        return ThreadLocalRandom.current().nextInt(1, 49);
    }

    public static void trianglePascal(int height){

        int [] array = new int[1];
        if(array.length > 0) array[0] = 1;

        for(int i=height-1; i > 0 ; i--) {

            printS(i);
            for (int j: array) {
                printI(j);
            }
            printN();

            int [] newArray = new int[array.length+1];
            newArray[0] = 1;
            for(int a=1; a < newArray.length-1; a++){
                if(a < array.length) {
                    newArray[a] = array[a] + array[a - 1];
                }
            }
            newArray[newArray.length-1] = 1;
            array = newArray;
        }
    }

    private static void printS(int n){
        System.out.printf("%"+n+"s","");
    }

    private static void printI(int i){
        System.out.printf("%d ",i);
    }

    private static void printN(){
        System.out.printf("%n");
    }
}
