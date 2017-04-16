import java.util.ArrayList;
import java.util.List;

public class BinaryGapKata {

    public static void main(String[] args) {

        String binary = "0100101110001";
        char [] chars = binary.toCharArray();

        List<Integer> indexes = new ArrayList<>(chars.length);
        for(int i=0; i < chars.length;i++){
            if(chars[i] == '1') indexes.add(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i < indexes.size(); i++) {
            int value = indexes.get(i) - indexes.get(i-1) -1;
            if(value > max) {
                max = value;
            }
        }
        System.out.println(max);

        // LUB
        int bin = 0b0100101110001;
        String binaryStr = Integer.toBinaryString(bin);
        String [] zeros = binaryStr.split("1");
        int gap = Integer.MIN_VALUE;
        for(String subZeros : zeros) {
            gap = subZeros.length() > gap ? subZeros.length() : gap;
        }
        System.out.println(gap);
    }
}
