public class CountTriangles {


    public static void main(String[] args) {
        System.out.print(solution(new int[] {10,2,5,1,8,12}, 6));
    }

    public static int solution(int A[], int N) {
        if(N < 3) return 0;
        int counter = 0;
        for(int p=0; p < N-2; p++) {
            for(int q=p+1; q < N-1; q++) {
                for(int r=q+1; r < N; r++) {
                    if(A[p] + A[q] > A[r] && A[q] + A[r] > A[p] && A[r] + A[p] > A[q]) {
                        counter +=1;
                    }
                }
            }
        }
        return counter;
    }
}
