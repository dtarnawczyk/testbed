package codility;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Fish {

public static void main(String[] args) {
		
//		int [] A = {4, 3, 2, 1, 5};
//		int [] B = {0, 1, 0, 0, 0};
		
		int [] A = {0 ,1};
		int [] B = {1, 1};
		
				
		System.out.println(solution(A, B));
		
		System.out.println(multiply(4.54, 3.43));

	}

	public static Double multiply(Double a, Double b) {
		return a * b;
	}
	
	public static int solution(int A[], int B[]) {
		
		Deque<int []> stack = new ArrayDeque();
		
		IntStream.range(0, A.length).forEach(i->{
			
			int [] fish = {A[i], B[i]};
			
			if(stack.isEmpty()) {
				
				stack.add(fish);
				
			} else {
				
				int [] previousFish = stack.peek();
				
				if ((previousFish[1] == 0) && ((fish[1] == 1) || (fish[1] == 0)) ||
					(previousFish[1] == 1) && (fish[1] == 1) ) {
					
					stack.push(fish);
					
				} else {
				
					if (previousFish[0] < fish[0]) {
						
						stack.pop();
						stack.push(fish);
					}
				}	
			}						
		});
		
		return stack.size();
	}

}
