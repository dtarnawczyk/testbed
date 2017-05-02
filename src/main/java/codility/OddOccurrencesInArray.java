package codility;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int [] A = {10, 2, 8, 4, 2, 8, 4};
		
		System.out.println(solution2(A));

	}
	
	static int solution(int [] A) {
		int tableSize = A.length;
		for(int i=0; i < tableSize; i++){
			if(A[i] > 0){
				for (int ii = i+1; ii < tableSize; ii++){
					if(A[ii] == A[i]){
						A[i]=0;
						A[ii]=0;						
						break;
					}
				}
			}
		}
		int unpair = 0;
		for(int i=0; i < tableSize; i++){
			if(A[i] > 0){
				unpair = A[i];
			}
		}
		return unpair;
	}
	
	static int solution2(int [] A) {
		int unpaired = A[0];
		for(int i=1; i < A.length; i++){
			unpaired = unpaired ^ A[i];
		}
		return unpaired;
	}

}
