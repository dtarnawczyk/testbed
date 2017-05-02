

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		String secondLine = in.nextLine();
		in.close();
		BigInteger firstNumber = new BigInteger(firstLine);
		BigInteger secondNumber = new BigInteger(secondLine);
		System.out.println(firstNumber.add(secondNumber));
		System.out.println(firstNumber.multiply(secondNumber));
    }
}
