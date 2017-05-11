import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringRotate {

    static int shiftedDiff(String first, String second){
        if(first.length() != second.length()) return -1;
        if(first.equals(second)) return -1;
        char [] firstArray = first.toCharArray();
        int maxRotator = first.length();
        for(int i=maxRotator-1; i >= 0; i--){
            char [] tmp = new char[maxRotator];
            for(int j=0; j < maxRotator ; j++){
                tmp[j] = firstArray[(j+i) % maxRotator];
            }
            String tmpString = String.valueOf(tmp);
            if(tmpString.equals(second)){
                return maxRotator-i;
            }
        }
        return -1;
    }

    // briliant !!!
    static int shiftedDiff2(String first, String second){
        if (first.length() != second.length())
            return -1;
        return (second + second).indexOf(first);
    }

    @Test
    public void test() {
        assertEquals(-1, StringRotate.shiftedDiff("hoop","pooh"));
        assertEquals(2, StringRotate.shiftedDiff("coffee","eecoff"));
        assertEquals(4, StringRotate.shiftedDiff("eecoff","coffee"));
    }

}
