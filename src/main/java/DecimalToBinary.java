public class DecimalToBinary {

    public static void main(String[] args) {
        decimalToBinary(4);
        System.out.println();
        System.out.println(Integer.toBinaryString(4));
    }

    public static void decimalToBinary(int decimal) {
        int [] binary = new int [25];
        int index = 0;
        while(decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal /2;
        }
        for(int i = index-1; i >= 0; i--){
            System.out.print(binary[i]);
        }
    }
}
