import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String firstLine  = in.nextLine();
		String [] firstLineArray = firstLine.split("\\s");
		int N = Integer.parseInt(firstLineArray[0]);
		int d = Integer.parseInt(firstLineArray[1]);
		if(N > 0){
			String inputArrayString = in.nextLine();
			String [] inputArray = inputArrayString.split("\\s");
			in.close();
			String [] newArray = new String[N];
			if(d > N) {
				d = d % N;
			}
			for (int i = 0; i < N; i++) {
				int rotator = N - (i+1) - d;
				if(rotator < 0) {
					rotator = N+rotator;
					newArray[rotator] = inputArray[N-(i+1)];
				} else {
					newArray[rotator] = inputArray[N-(i+1)];
				}
			}
			for(String s : newArray) {
				System.out.print(s+" ");
			}
		}

	}

}
