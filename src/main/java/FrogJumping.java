public class FrogJumping {

    public static void main(String[] args) {
        int [] array = {1, 2, 2, -1};
        System.out.println(solution(array)); // exp: 4

        int [] array2 = {1, 2, 1, 5};
        System.out.println(solution(array2)); // exp: 3

        int [] array3 = {1, 2, 3, 1, -2, 1};
        System.out.println(solution(array3)); // exp: 6

        int [] array4 = {-1, -1, -2};
        System.out.println(solution(array4)); // exp: 1

        int [] array5 = {1, -1};
        System.out.println(solution(array5)); // exp: -1
    }

    public static int solution(int[] array) {
        int position = 0;
        int counter = 0;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if(sum == 0) return -1;

        do {

            position += array[position];
            counter++;

        } while (position >= 0 && position < array.length);

        return counter == 0 ? -1 : counter;
    }

}
