package codility;

import java.util.Arrays;

public class StoneWall {

	public static void main(String[] args) {
		
		int [] H = new int [] {8, 8, 5, 7, 9, 8, 7, 4, 8};
		
		System.out.println(solution(H));
	}
	
	public static int solution(int [] H) {
		
		int blockCounter = 0;
		int [] tmp = new int[H.length];
		
		while(tableHasNoZeroElements(H)) {
			int blockHeight = H[0];
			for (int i=1; i < H.length; i++) {	
				if(blockHeight == H[i]) {
					H[i-1] = 0;
					tmp[i] = 0;
				} else if (blockHeight < H[i]) {	
					if(blockHeight == 0){
						blockHeight = H[i];
						tmp[i] = 0;
						H[i-1] = 0;
					} else {
						tmp[i] = Math.abs(H[i] - blockHeight);
						H[i-1] = 0;
					}
					if(i+1 == H.length){
						blockCounter +=1;
					}
				} else {
					blockCounter +=1;
					H[i-1] = 0;
					
					tmp[i] = 0;
					
					blockHeight = H[i];
				}
			}
			H = tmp.clone();
			Arrays.fill(tmp, 0);
		}
		return blockCounter;
		
	}
	
	public static boolean tableHasNoZeroElements(int [] H) {
		for (int i=0; i < H.length; i++) {
			if(H[i] > 0) return true;
		}
		return false;
	}

}
