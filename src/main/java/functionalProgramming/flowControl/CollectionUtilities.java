package functionalProgramming.flowControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CollectionUtilities {

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> list(List<T> list) {
        return Collections.unmodifiableList(new ArrayList<>(list));
    }

    @SafeVarargs
    public static <T> List<T> list(T... t) {
        return Collections.unmodifiableList(Arrays.asList((Arrays.copyOf(t, t.length))));
    }

    public static <T> T head(List<T> list){
        if(list.isEmpty()){
            throw new IllegalStateException("head for empty list");
        }
        return list.get(0);
    }

    private static <T> List<T> copy(List<T> list){
        return new ArrayList<>(list);
    }

    public static <T> List<T> tail(List<T> list){
        if(list.isEmpty()){
            throw new IllegalStateException("tail for empty list");
        }
        List<T> workList = copy(list);
        workList.remove(0);
        return Collections.unmodifiableList(workList);
    }

    public static <T> List<T> append(List<T> list, T t){
        List<T> workList = copy(list);
        workList.add(t);
        return Collections.unmodifiableList(workList);
    }

    /*NOT FOR PRODUCTION - TOO SLOW*/
    public static <T> List<T> prepend(List<T> list, T t){
       return foldLeft(list, list(t), a -> b -> append(a, b));
    }

    /*NOT FOR PRODUCTION - TOO SLOW*/
    public static <T> List<T> reverse(List<T> list){
        return foldLeft(list, list(), x -> y -> prepend(x, y));
    }

    public static Integer fold(List<Integer> list, Integer starter, Function<Integer, Function<Integer, Integer>> function){
        int result = starter;
        for(Integer i : list){
            result = function.apply(result).apply(i);
        }
        return result;
    }

    public static <T, U> U foldLeft(List<T> list, U starter, Function<U, Function<T, U>> function){
        U result = starter;
        for(T t : list){
            result = function.apply(result).apply(t);
        }
        return result;
    }

    public static <T, U> U foldRight(List<T> list, U starter, Function<T, Function<U, U>> function){
        U result = starter;
        for(int i = list.size(); i > 0; i--){
            result = function.apply(list.get(i-1)).apply(result);
        }
        return result;
    }
}
