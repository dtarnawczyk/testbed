import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatsAndAMouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        List<int []> arr = new ArrayList<>();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            int [] t = new int[]{x, y, z};
            arr.add(t);
        }
        for (int i []  : arr) {
            int a = Math.abs(i[2] - i[0]);
            int b = Math.abs(i[2] - i[1]);
            if (a > b) System.out.println("Cat B");
            else if (a < b) System.out.println("Cat A");
            else System.out.println("Mouse C");
        }

    }
}
