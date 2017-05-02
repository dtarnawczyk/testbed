

import java.util.Scanner;

public class DiagonalDifference {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int [][] A = new int[N][N];
		if (N > 0) {
			for( int i = 0; i < N; i++) {
				String [] line =  in.nextLine().split("\\s");
				for( int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(line[j]);
				}
			}
			in.close();	
			int firstDiagonalSum = 0;
			int secondDiagonalSum = 0;
			for(int i=0; i < N; i++) {
				firstDiagonalSum += A[i][i];
				secondDiagonalSum += A[(N-1)-i][i];
			}
			System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
		}
	}
}
