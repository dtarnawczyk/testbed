
public class DRoot {

    public static void main(String[] args) {

        System.out.print(digital_root(493193));
    }

    public static int digital_root(int n) {
        int number = digitalRoot(n);
        while(number / 10 > 0){
            number = digitalRoot(number);
        }
        return number;
    }

    private static int digitalRoot(int n) {
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
