package codility;

import java.util.stream.IntStream;

public class PermMissingElements {

	public static void main(String[] args) {
		
		System.out.println(solution2(new int[] {2,3,1,5}));

	}

	static int solution(int [] A){
		
		int N = A.length+1;
		int all = (N * (N + 1)) /2;
		int sum = 0;
		for(int i : A){
			sum +=i;
		}
		return (all - sum);
		
	}
	
	static int solution2(int [] A){
		
		int [] B = new int [A.length+1];
		for(int i=0; i < A.length+1; i++){
			B[i] = i+1;
		}
		
		int sumA = IntStream.of(A).sum();
		int sumB = IntStream.of(B).sum();
		return (sumB - sumA);
		
	}
}
