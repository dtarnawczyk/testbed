package codility;

public class CycleRotation {

	public static void main(String[] args) {
		int [] A = {1 , 2, 3, 4, 5, 6};
		int [] B = solution(A, 3);
		for(int i=0; i < B.length; i++){
			System.out.print(B[i]);
		}
	}
	
	static int [] solution(int [] A, int K) {
		int [] B = new int[A.length];
		if(K <= 0) {
			return A;
		} else {
			for(int i=0; i < K; i++){
				B = new int[A.length];
				for(int ii = 0; ii < B.length; ii++){
					int index = ii+1;
					if(index < B.length){
						B[index] = A[ii];
					} else {
						B[0] = A[A.length-1];
					}
				}
				A = B;
			}
			return B;
		}	
	}

}
