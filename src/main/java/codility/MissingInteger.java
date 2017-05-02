package codility;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution2(new int [] {2}));
	}

	// Moje - �le
	public static int solution(int[] A) {
		A = Arrays.stream(A).distinct().sorted().toArray();
		int begin = A[0];
		for(int i=1; i < A.length; i++){
			if(begin+i != A[i]){
				return begin+i;
			}
		}
		return begin;
	}
	
	 public static int solution2(int[] A) {
	        int N = A.length+1;
	        boolean[] numPresent = new boolean[N + 1];
	        for (int i = 1; i < N; i++) {
	            if (A[i-1]  == N) {
	                continue;
	            }
	 
	            if (!numPresent[A[i-1]]) {
	                numPresent[A[i-1]] = true;
	            }
	        }
	 
	        int smallest = 1;
	        for (int j = 1; j < numPresent.length; j++) {
	 
	            if (!numPresent[j]) {
	                smallest = j;
	                break;
	            }
	            smallest++;
	        }
	        return smallest;
	    }

}
