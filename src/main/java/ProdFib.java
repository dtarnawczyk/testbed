import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ProdFib {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ProdFib.productFib(714)));
        System.out.println(Arrays.toString(ProdFib.productFib(800)));
        System.out.println(Arrays.toString(ProdFib.productFib(1)));

    }

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }

    public static long[] productFib(long prod) {
        if(prod == 1) return new long[] {1, 1, 1};
        long first = 1, second = 1, found = 0;
        for(int i = 2; i < (Math.sqrt(prod)+1)/2; i++){
            if(first * second < prod) {
                long tmp = first;
                first = second;
                second = tmp + second;
            } else {
                if(first * second == prod) {
                    found = 1;
                }
                break;
            }
        }
        return new long[] {first, second, found};
    }

}
