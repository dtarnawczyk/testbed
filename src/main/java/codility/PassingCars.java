package codility;

public class PassingCars {

public static void main(String[] args) {
		
		System.out.println(solution(new int[] {0,1,0,1,0,1,1,1,0}));

	}

// �le w chuj
	static int solution(int [] A){
		int zerosCount = 0;
		int onesCount = 0;
		for(int a : A){
			if(a == 0){
				zerosCount += 1;
			} else {
				onesCount += 1;
			}
		}
		int min = Math.min(zerosCount, onesCount);
		int div = A.length / 2;
		if((A.length % 2) == 0){
			return div * min;
		} else {
			return (div * min) + 1;
		}
	}
	
	static public int solution2(int[] A) {
        int countOfZeros = 0, count = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] == 0) countOfZeros++;                    
            if (A[i] == 1) count += countOfZeros;    
            if (count > 1000000000) return -1;
        }
        return count;
	}
}
