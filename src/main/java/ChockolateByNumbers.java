public class ChockolateByNumbers {

    public static void main(String[] args) {

        System.out.println(solution(10, 4)); //5
        System.out.println(solution(2, 1)); //2
        System.out.println(solution(12, 21)); //4
        System.out.println(solution(1, 2)); //1
    }

    public static int solution(int N, int M) {
        if( N == M) {
            return 1;
        }
        if(M == 1 || N == 1) return N;
        int counter = 0,i = 1, j=1;
        while(j % N != 0) {
            i += 1;
            if (i % M == 0) {
                counter += 1;
                j = i;
            }
        }


        return counter;
    }
}
