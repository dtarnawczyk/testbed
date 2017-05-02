package codility;

import java.util.ArrayList;
import java.util.stream.Stream;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println("Solution: "+solution(15));
	}
	
	static int solution(int x) {
		String x_bin = Integer.toBinaryString(x);
		int zeroCounter = 0;
		ArrayList<Integer> listOfZeroCounter = new ArrayList<Integer>();
		int counter = 0;
		for(char a : x_bin.toCharArray()){
			if(a == '1') {
				counter++;
				int counterSave = counter;
				try {
					while (x_bin.charAt(counter) == '0') {
						counter++;
						zeroCounter++;
					}
					listOfZeroCounter.add(zeroCounter);
				} catch (StringIndexOutOfBoundsException ex) {
				} finally {
					zeroCounter = 0;
					counter=counterSave;
				}

			} else {
				counter++;
			}
		}
		int zeros = 0;
		if(listOfZeroCounter.size() > 0){
			int max = listOfZeroCounter.get(0);
			for (int i = 1; i < listOfZeroCounter.size(); i++) {
				if (listOfZeroCounter.get(i) > max) {
					max = listOfZeroCounter.get(i);
				}
			}
			zeros = max;
		}
		return zeros;
	}
	
	// Best solution Java8 and streams
	static int calculateBinaryGap(int N) {
	    return Stream
	        .of(
	            // integer to binary string
	            Integer.toBinaryString(N)
	                // trim 0(s) at the end
	                .replaceAll("0+$", "")
	                // split string with 1(s)
	                .split("1+"))
	        // lambda expressions: use filter to keep not null elements
	        .filter(a -> a != null)
	        // method references: convert string to integer by using the
	        // length of string
	        .map(String::length)
	        // method references: find the largest number in the stream by
	        // using integer comparator
	        .max(Integer::compare)
	        // return 0 if nothing matches after the process
	        .orElse(0);
	    }
	
	

}
