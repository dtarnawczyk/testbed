package codility;

import java.util.stream.IntStream;

public class TapeEquilibrium {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {3,1,2,4,3}));

	}
	
	static int solution(int[] A) {
		int N = A.length;
		int [] difs = new int [N - 1];
		for(int i = 1; i <= N-1; i++){
//			int sum1=0;		
//			for(int a=0; a <= (i-1); a++){
//				sum1 = sum1 + A[a];
//			}
			int sum1 = IntStream.range(0, i).map(n -> A[n]).sum();
			
			int sum2=0;
			for(int b=i; b <= (N-1); b++){
				sum2 = sum2 + A[b];
			}
			System.out.println("Absolute: "+ Math.abs(sum1-sum2));
			difs[i-1] = Math.abs(sum1-sum2);
		}
		return IntStream.of(difs).min().getAsInt();
		
	}

}
