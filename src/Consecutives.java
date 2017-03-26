import java.util.*;
import java.util.stream.IntStream;

public class Consecutives {

    public static void main(String [] args) {
        System.out.println(sumConsecutives(Arrays.asList(1,4,4,4,0,4,3,3,1)));
        System.out.println(sumConsecutives(Arrays.asList(-5,-5,7,7,12,0)));
    }

    public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> result = new ArrayList();
        result.add(s.get(0));
//        for (int i = 1; i < s.size(); i++){
//            if(s.get(i-1) == s.get(i)){
//                int lastIndex = result.size()-1;
//                result.set(lastIndex, result.get(lastIndex) + s.get(i));
//            } else {
//                result.add(s.get(i));
//            }
//        }
        IntStream.range(1, s.size()).forEach(i -> {
            if(s.get(i-1) == s.get(i)){
                int lastIndex = result.size()-1;
                result.set(lastIndex, result.get(lastIndex) + s.get(i));
            } else {
                result.add(s.get(i));
            }
        });
        return result;

    }
}
