public class Persist {

    public static void main(String [] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(4));
        System.out.println(persistence(25));
        System.out.println(persistence(999));
    }

    public static int persistence(long number) {

        long multiply = 1;
        int counter = 0;
        if(number / 10 == 0) {
            return counter;
        }
        while (multiply > 0) {
            multiply = 1;
            while (number > 0) {
                int digit = (int) (number % 10);
                multiply *= digit;
                if(number / 10 == 0){
                    number = multiply;
                    break;
                }
                number = number / 10;
            }
            counter +=1;
            if(multiply / 10 == 0) {
                break;
            }
            multiply = multiply / 10;
        }
        return counter;
    }
}
