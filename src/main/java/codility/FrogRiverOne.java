package codility;

import java.util.Arrays;

public class FrogRiverOne {

	public static void main(String[] args) {
		int [] A = {1, 3, 1, 4, 2, 3, 5, 4};
		
		System.out.println(solution(5, A));
	}

	static int solution (int X, int [] A){
		int timer = -1;
		boolean finished = false;
		
		int [] B = new int[X+1];
		Arrays.fill(B, 0);
		
		int counter = 0;
		
		for(int i=0; i < A.length; i++){
			
			timer++;
			
			if(B[A[i]] == 0){
				counter++;
				B[A[i]] = 1;
			}
			
			if(counter == X) {
				finished = true;
				break;
			}
		
		}
		if(finished){
			return timer;
		}
		return -1;
	}
}
