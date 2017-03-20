import java.util.ArrayList;
import java.util.List;

public class BinaryGap {

    public static void main(String [] args) {
        String binaryString = "010101010";
        char [] tableOfInt = binaryString.toCharArray();
        int n = tableOfInt.length;
        List<Integer> indexesOfZeros = new ArrayList(n);
        for(int i=0; i < n; i++){
            if(tableOfInt[i] == '1'){
                indexesOfZeros.add(i);
            }
        }
        System.out.println(indexesOfZeros);
        if(indexesOfZeros.size() > 0){
            int gap = 0;
            if(indexesOfZeros.get(1) != null) {
                gap = Math.abs(indexesOfZeros.get(0) - indexesOfZeros.get(1))-1;
            }
            for(int i=1; i < indexesOfZeros.size()-1; i++){
                    int nextGap = Math.abs(indexesOfZeros.get(i) - indexesOfZeros.get(i+1))-1;
                    if ( gap < nextGap ) {
                        gap = nextGap;
                    }
            }
            System.out.println(gap);
        }

    }
}
