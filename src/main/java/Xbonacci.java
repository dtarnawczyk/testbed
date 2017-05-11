import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        if(n==0) return new double[n];
        double n0 = s[0];
        double n1 = s[1];
        double n2 = s[2];
        double [] output = new double[n];
        output[0] = n0;
        output[1] = n1;
        output[2] = n2;
        double next;
        for(int i = 3; i < n; i++) {
            next = n0 + n1 + n2;
            output[i] = next;
            n0 = n1;
            n1 = n2;
            n2 = next;
        }
        return output;
    }

    private Xbonacci variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, variabonacci.tribonacci(new double []{1,1,1},10));
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, variabonacci.tribonacci(new double []{0,0,1},10));
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, variabonacci.tribonacci(new double []{0,1,1},10));
    }

    private void assertArrayEquals(double []expecteds, double[] actuals) {
        for(int i = 0; i < actuals.length; i++)
            assertEquals(expecteds[i], actuals[i], 1e-10);
    }
}
