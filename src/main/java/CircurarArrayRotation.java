public class CircurarArrayRotation {

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        a = rotateArrayKTimes(a, k);
//        int [] queries = new int[q];
        for(int a0 = 0; a0 < q; a0++){
            System.out.println(a[in.nextInt()]);
        }
        in.close();
//        for(int i : queries){
//
//        }
*/
        int [] a = new int[]{1,2,3};
        a = rotateArrayKTimes(a, 2);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
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
        int [] current = inputArray;
        int N = current.length;
        int [] newTable = new int[N];
//        while(rotator > 0) {?
//            rotator -= 1;
            for (int i = 0; i < N; i++) {
                if ((i - 1) < 0) {
                    newTable[0] = current[N - k - i];
                } else {
                    newTable[i] = current[i - k - 1];
                }
            }
            current = newTable;
            newTable = new int[N];
//        }
        return current;
    }
}
