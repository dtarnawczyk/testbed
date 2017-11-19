package functionalProgramming.flowControl;

import java.util.List;
import java.util.function.Function;

import static functionalProgramming.flowControl.CollectionUtilities.*;

public class CollectionUtilsTester {
    public static void main(String[] args) {
        List<Integer> list = list(1,2,3,4,5);
        int sum = fold(list, 0, x -> y -> x+y);
        System.out.println(sum);

        int multiplication = fold(list, 1, x -> y -> x*y);
        System.out.println(multiplication);

        Function<String, Function<Integer, String>> f = x -> y -> addSI(x, y);
        String starter = "0";
        System.out.println(foldLeft(list, starter, f));

        Function<Integer, Function<String, String>> f2 = x -> y -> addSI2(x, y);
        System.out.println(foldRight(list, starter, f2));
    }

    static String addSI(String s, Integer i){
        return "("+s+" + "+i+")";
    }

    static String addSI2(Integer i, String s){
        return "("+s+" + "+i+")";
    }
}
