import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FindUniqueNumber {
    
    public static double findUniq2(double arr[]) {

        Map<Double, Integer> map = new HashMap<>();
        for(double d : arr){
            if(map.containsKey(d))
                map.put(d, map.get(d)+1);
            else
                map.put(d, 1);
        }
        return map.entrySet().stream().filter(m -> m.getValue() == 1).findAny().get().getKey();
    }

    public static double findUniq(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniqueNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniqueNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

}
