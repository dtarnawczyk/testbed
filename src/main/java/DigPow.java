import java.util.ArrayList;
import java.util.List;

public class DigPow {

	public static void main(String[] args) {
		
		System.out.println(digPow(46288, 3));
		System.out.println(digPow(92, 1));
		System.out.println(digPow(89, 1));
		System.out.println(digPow(695, 2));
		
		
	}
	
	public static long digPow(int n, int p) {
		int nSave = n;
		List<Integer> integers = new ArrayList();
		while(n!=0) {
			int digit = n % 10;
			integers.add(digit);
			n = n / 10;
		}
		long sum = 0;
		for(int i = integers.size()-1; i >= 0; i--){
			sum += Math.pow(integers.get(i), p);
			p++;
		}
		long div = (sum/nSave);
		return sum/nSave == 0 ? -1 : div; 
	}

}
