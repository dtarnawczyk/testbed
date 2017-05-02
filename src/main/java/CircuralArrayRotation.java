
import java.util.Scanner;

public class CircuralArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        a = rotateArrayKTimes(a, k);
        int [] queries = new int[q];
        for(int a0 = 0; a0 < q; a0++){
        	queries[a0] = in.nextInt();
        }
        in.close();
        for(int i : queries){
        	 System.out.println(a[i]);
        }

//        int [] a = new int[]{1,2,3,4,5,6};
//        a = rotateArrayKTimes(a, 8);
//        for(int i = 0; i < a.length; i++){
//            System.out.println(a[i]);
//        }
    }

//    public static int [] rotateArrayKTimes(int [] inputArray, int rotator) {
//        int [] current = inputArray;
//        int N = current.length;
//        int [] newTable = new int[N];
//        while(rotator > 0) {
//            rotator -= 1;
//            for (int i = 0; i < N; i++) {
//                if ((i - 1) < 0) {
//                    newTable[0] = current[N - 1];
//                } else {
//                    newTable[i] = current[i - 1];
//                }
//            }
//            current = newTable;
//            newTable = new int[N];
//        }
//        return current;
//    }

    public static int [] rotateArrayKTimes(int [] inputArray, int k) {
    	int N = inputArray.length;
    	int [] newTable = new int[N];
    	if(k > N) 
    		k = k % N;
    	for (int i = 0; i < N; i++) {
    		int val = N - k + i;
    		if ( val < N) {
    			newTable[i] = inputArray[val];
    		} else {
    			newTable[i] = inputArray[i - k];
    		}
    	}

    	return newTable;
    }
}