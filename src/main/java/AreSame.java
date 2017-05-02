import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreSame {

	public static void main(String[] args) {
		int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
		
		a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
		b = new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361};
		
						
		System.out.println(comp(a, b));
	}
	
	public static boolean comp(int [] a, int [] b){
		if (a == null || b == null) return false;
		if (a.length == 0 && b.length == 0) return true;
		if (a.length != b.length) return false;
		List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
		for(int i=0; i < a.length; i++) {
			if(!listB.contains(a[i] * a[i])) return false;
		}
        return true;
	}
	
	

}
