

import java.util.Scanner;

public class ArrayDS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		if(N > 0){
			String input = in.nextLine();
			in.close();
			String [] inputArray = input.split("\\s");
			String [] newArray = new String[N];
			for (int i = 0; i < N; i++) {  
				newArray[i] = inputArray[(N-1) - i];
			}
			for (int i = 0; i < N; i++) {  
				System.out.print(newArray[i]+" ");
			}
			
		}
	}
}
