

import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = 6;
		int [][] A = new int[arraySize][arraySize];
		for (int i=0;i<arraySize;i++) {
			String [] line =  in.nextLine().split("\\s");
			for (int j=0; j<arraySize ;j++) {

				A[i][j] = Integer.parseInt(line[j]);
			}
		}
		in.close();
		
		int max = A[0][0] + A[0][1] + A[0][2] + A[1][1] + A[2][0] + A[2][1] + A[2][2];
		for (int i=0; i <= 3; i++) {
			for (int j=0; j <= 3; j++) {				
				int sum = A[i][j] + A[i][j+1] + A[i][j+2] + A[i+1][j+1] + A[i+2][j] + A[i+2][j+1] + A[i+2][j+2];
				if(sum > max) {
					max = sum;
				}
				
			}
		}
		
		System.out.println(max);
		
		

	}

}
