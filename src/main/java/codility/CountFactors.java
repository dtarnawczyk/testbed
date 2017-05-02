package codility;

import java.util.stream.IntStream;

public class CountFactors {

	public static void main(String[] args) {
		
		System.out.println(solution(12));
		System.out.println(solution(24));
		System.out.println(solution(15));
		System.out.println(solution(10));
	}
	
	public static int solution(int N) {
		if(N == 1) return 1;
		int factorCounter = 1;
		int half = 0;
		if(N/2 == 0){
			half = N/2;
		} else {
			half = N/2 +1;
		}
		factorCounter += IntStream.range(1, half).parallel().filter(i -> N%i == 0).count();
//		for(int i=1; i <= half; i++) {
//			if(N % i == 0) {
//				factorCounter +=1;
//			}
//		}
		return factorCounter;
				
	}

}
