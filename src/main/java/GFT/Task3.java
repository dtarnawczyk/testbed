package GFT;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String [] inputs = {"bbb", "ccc", "aaaa"};
        Map<Integer, String> output = fillMapInData(inputs);
        System.out.println(output);
        Collection<Integer> keys = getKeys(output);
        System.out.println(keys);
        System.out.println(getValues(output));
    }

    public static Map<Integer, String> fillMapInData(String[] values) {
        Map<Integer, String> output = new HashMap<>();
        for(int i=1; i <= values.length; i++){
            output.put(i, values[i-1]);
        }
        return output;
    }

    public static Collection<Integer> getKeys(Map<Integer, String> map) {
        Collection<Integer> output = new ArrayList<>();
        List<String> mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        for(String value : mapValues){
            for(Integer key : map.keySet()){
                if(value.equals(map.get(key))){
                    output.add(key);
                    break;
                }
            }
        }
        return output;
    }


    public static Collection<String> getValues(Map<Integer, String> map) {
        return map.values().stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }

}
