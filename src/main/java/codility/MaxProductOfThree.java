package codility;

public class MaxProductOfThree {

	public static void main(String[] args) {
//		int [] testArray = new int[] { -3, 1, 2, -2, 5, 6};
		int [] testArray = new int[] { -5, -6, -4, -7, -10};

		
		System.out.println(solution(testArray));
	}

	public static int solution(int[] A){
		int N = A.length;
		if(N >= 3) {
			int highestMutiply = A[0]*A[1]*A[2];
			for (int i=0; i <= (N-3); i++) {
				for (int j=(i+1); j<= (N-2); j++) {
					for(int k=(i+2); k <= (N-1); k++){
						if ( i < j && j < k) {
							int triplet = A[i] * A[j] * A[k];
							if (triplet > highestMutiply) {
								highestMutiply = triplet;
							}
						}
					}
				}
			}
			return highestMutiply;
		} else {
			return 0;
		}
	}

}
