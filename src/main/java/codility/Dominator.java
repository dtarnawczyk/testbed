package codility;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dominator {

	public static void main(String[] args) {
	
		int [] A = {3,4,3,2,3,-1,3,3};
		System.out.println(solution(A));

	}

	public static int solution(int[] A) {
		Deque<Integer> stack = new ArrayDeque();
		for(int a : A){
			if(stack.isEmpty()) {
				stack.push(a);
			} else {
				if(stack.peek() != a) {
					stack.pop();
				} else {
					stack.push(a);
				}
			}
		}
		if(!stack.isEmpty()){
			int candidate = stack.pop();
			long count = Arrays.stream(A).filter(a -> a == candidate).count();
			if(count >= A.length/2) {
				for(int i=0; i < A.length; i++){
					if(A[i] == candidate) return i;
				}
			}	
		}
		return -1;
	}
}
