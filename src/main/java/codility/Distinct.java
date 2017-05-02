package codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Distinct {

	public static void main (String [] args){
		
		int [] A = new int [] {2, 1 ,1, 2, 3, 1};
		
		System.out.println(  Arrays.stream(A).distinct().count());

		System.out.println("OR");
		
		Set set2 = Arrays.stream(A).boxed().collect(Collectors.toSet());
		System.out.println(set2.size());
	}
}
