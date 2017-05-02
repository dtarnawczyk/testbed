package codility;
public class MinPerimeterRectangle {

	public static void main(String[] args) {
		
		System.out.println(solution(30));
//		System.out.println(solution(24));
//		System.out.println(solution(15));
//		System.out.println(solution(10));
	}
	
	public static int solution(int N) {
		if(N == 1) return 4;
		int A = 1;
		int B = N;
		int minPerimaterRectangle = 2 * (A + B);
		int half = 0;
		if(N/2 == 0){
			half = N/2;
		} else {
			half = N/2 +1;
		}
		for(int i=1; i <= half; i++) {
			if(N % i == 0) {	
				A = i;
				B = N / i;
				int localMin = 2 * (A+B);
				if(localMin < minPerimaterRectangle) minPerimaterRectangle = localMin;
			}
		}
		return minPerimaterRectangle;
				
	}
}
