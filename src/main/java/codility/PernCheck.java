package codility;

import java.util.Arrays;

public class PernCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1,2,3,4,5,6}));
	}

	public static int solution(int[] A) {
		A = Arrays.stream(A).sorted().toArray();
		for(int i=0; i < A.length; i++){
			if(A[i] != (i+1)){
				return 0;
			} 
		}
		return 1;
	}
	
}
