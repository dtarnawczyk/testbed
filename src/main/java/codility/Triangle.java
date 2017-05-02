package codility;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		int [] A = {10, 2, 5, 1, 8, 20};
		System.out.println(solution(A));
	}
	
	public static int solution(int [] A) {
		if (A.length < 3) {
			return 0;
		}
		Arrays.sort(A);
		for (int i=0; i < A.length; i++) {
			for (int j=i+1; j < A.length; j++) {
				for (int k=i+2; k < A.length; k++) {
					if ((i < j) && (j < k)) {
						if ((A[i] + A[j] > A[k]) && 
							(A[j] + A[k] > A[i]) &&
							(A[k] + A[i] > A[j]) ) {
							return 1;
						}
					}
				}
			}
		}
		return 0;
	}

}
