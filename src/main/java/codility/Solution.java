package codility;

public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a0 = in.nextInt();
//        int a1 = in.nextInt();
//        int a2 = in.nextInt();
//        int b0 = in.nextInt();
//        int b1 = in.nextInt();
//        int b2 = in.nextInt();
//        int [] A = new int[]{a0,a1,a2};
//        int [] B = new int[]{b0,b1,b2};
        int [] A = new int[]{10,15,20};
        int [] B = new int[]{5,6,7};
        int counterA = 0;
        int counterB = 0;
        for(int i=0; i < 3; i++){
        	if ( A[i] > B[i] )
        		counterA +=1;
        	else if ( A[i] < B[i] )
        		counterB +=1;
        }
        System.out.println(counterA+" "+counterB);
    }
}
