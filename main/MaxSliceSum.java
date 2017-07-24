
public class MaxSliceSum {

    public static void main(String [] args) {
        System.out.println(solution(new int []{3, 2, -6, 4, 0}));
        System.out.println(solution(new int []{-2, 1}));
        System.out.println(solution(new int []{-12}));
    }


    public static int solution(int [] A) {
        int max = A[0] , max_ending = 0;
        for(int i=0; i < A.length; i++){
            max_ending = Math.max(A[i], max_ending+A[i]);
            max = Math.max(max_ending, max);
        }
        return max;

    }
}
