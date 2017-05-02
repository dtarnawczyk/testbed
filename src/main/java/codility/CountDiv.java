package codility;

import java.util.stream.IntStream;

public class CountDiv {

	public static void main(String [] args) {
		System.out.println(solution3(6, 11, 2));
	}

	public static int solution(int start, int end, int dividedBy){
		int counter = 0;
		if (start < end) {
			for (int i = start; i <= end; i++){
				if ((i % dividedBy) == 0)
					counter += 1;
			}
		}
		return counter;
	}
	
	public static int solution2(int start, int end, int dividedBy){
		int count = (end - start) / dividedBy;
	    if (start % dividedBy == 0 || end % dividedBy == 0)
	        count++;
	    return count;
	}
	
	public static int solution3(int start, int end, int dividedBy){
	    return (int) IntStream.range(start, end).filter(i -> i % dividedBy == 0).count();
	}
	
}
