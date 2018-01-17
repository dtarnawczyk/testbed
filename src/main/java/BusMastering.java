import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class BusMastering {

    public static String arbitrate(String input, int n){
        int indexOfGreatest = input.indexOf("1");
        if (indexOfGreatest > -1) {
            input = input.replace("1","0");
            input = input.substring(0,indexOfGreatest) + "1" + input.substring(indexOfGreatest+1);
        }
        return input;
    }

    @Test
    public void basicTests() {
        assertEquals(BusMastering.arbitrate("001000101", 9), "001000000");
        assertEquals(BusMastering.arbitrate("000000101", 9), "000000100");
        assertEquals(BusMastering.arbitrate("0000", 4), "0000");
    }
}
