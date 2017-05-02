
import java.util.Scanner;

public class TimeConversion {

	public static void main(String [] args) {
		TimeConversion converter = new TimeConversion();
		Scanner in = new Scanner(System.in);
		String time = in.nextLine();
		in.close();
		converter.printTime24h(time);

	}
	
	public void printTime24h(String time){
		int h = transformStringToInt(time.substring(0, 2));
		int m = transformStringToInt(time.substring(3, 5));
		int s = transformStringToInt(time.substring(6, 8));
		String ampm = time.substring(8);

		if(ampm.equalsIgnoreCase("PM")){
			if(h != 12) {
				h = h + 12;
			}
		} else {
			if(h == 12) {
				h = 0;
			}
		}

		System.out.println(transformIntToString(h) 
				+ ":"+ transformIntToString(m)
				+":"+ transformIntToString(s));
		
	}

	public int transformStringToInt(String str) {
		str = (str.charAt(0) == '0') ? str.substring(1) : str;
		return Integer.parseInt(str);
	}

	public String transformIntToString(int integer) {
		return String.format("%2s", integer).replace(" ", "0");
	}
}
