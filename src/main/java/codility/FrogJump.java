package codility;

public class FrogJump {

	public static void main(String[] args) {
		
		System.out.println(solution3(10,85,30));
		System.out.println(solution3(20,20,5));
	}

	static int solution (int X, int Y, int D){
		int counter=0;
		if(X < Y){
			while(X < Y){
				X = X + D;
				counter++;
			}
		}
		return counter;
	}
	
	static int solution2 (int X, int Y, int D){
		int distance = Y - X;
		if (distance % D == 0)
			return distance/D;
		else
			return distance/D + 1;
	}
	
	static int solution3(int x, int y, int d) {
        return (int) Math.ceil((y - x) / (float)d);
    }
	
}
