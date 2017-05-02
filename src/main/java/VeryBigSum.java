import java.util.Scanner;

public class VeryBigSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		if(N > 0){
			String input = in.nextLine();
			in.close();
			long sum = 0;
			int counter = 0;
			for (String a : input.split("\\s")) {  
				counter++;
				if(counter <= N){
					sum += Long.parseLong(a);
				}
			}
			System.out.println(sum);
		}
	}

}
