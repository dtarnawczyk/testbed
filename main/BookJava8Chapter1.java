public class BookJava8Chapter1{


    public static void main(String [] args) {
        int input = 88;
        System.out.printf("%s%n", showBinary(input));
        System.out.printf("%s%n", showOctal(input));
        System.out.printf("%s%n", showHexadecimal(input));

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

}
