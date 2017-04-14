package rrdp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class R21 {

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(5);
        List<Integer> distinctList = linkedList.stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.asList(distinctList));
    }
}
