import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JourneyToThMoon {
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        List<List<Integer>> listOfPairs = new ArrayList();
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            List<Integer> pair = new ArrayList<>(2);
            pair.add(a);
            pair.add(b);
            listOfPairs.add(pair);
        }

        // Create missing lists of countries
        for(int i=0; i < N; i++){
            boolean listWithIExist = false;
            for(List pair : listOfPairs) {
                if(pair.contains(i)){
                    listWithIExist = true;
                    break;
                }
            }
            if(!listWithIExist){
                List<Integer> newList = new ArrayList<>(1);
                newList.add(i);
                listOfPairs.add(newList);
            }
        }

        // Marge lists with same countries
        List<List<Integer>> finalSetOfLists = new ArrayList();
        int listOfPairsSize = listOfPairs.size();
        for(int i=0; i < listOfPairsSize; i++) {

            List<Integer> firstList = listOfPairs.get(i);
            if (firstList != null) {
                for(int j=0; j < listOfPairsSize; j++) {
                    List<Integer> secondList = listOfPairs.get(j);
                    if (secondListContainsAnyOfFirst(firstList, secondList)) {

                        Set<Integer> integerSet = new HashSet();
                        integerSet.addAll(firstList);
                        integerSet.addAll(secondList);

                        List<Integer> newList = new ArrayList();
                        newList.addAll(integerSet);
                        listOfPairs.set(i, newList);
                        firstList = newList;
                    }
                }
            }

            if (!finalListContainsList(finalSetOfLists, firstList)) {
                finalSetOfLists.add(firstList);
            } else {

                for(int j=0; j< finalSetOfLists.size(); j++) {
                    List<Integer> list = finalSetOfLists.get(j);
                    if(!list.containsAll(firstList)) {
                        if (secondListContainsAnyOfFirst(list, firstList)) {
                            Set<Integer> integerSet = new HashSet();
                            integerSet.addAll(list);
                            integerSet.addAll(firstList);
                            List<Integer> newList = new ArrayList();
                            newList.addAll(integerSet);
                            finalSetOfLists.set(j, newList);
                            break;
                        }
                    }
                }
            }
        }


        // multiplication sum
        long combinations = 0;
        for(int i=0; i < finalSetOfLists.size(); i++) {

            List<Integer> firstList = finalSetOfLists.get(i);

            List<List<Integer>> sublist = finalSetOfLists.subList(i+1, finalSetOfLists.size());
            for(int j=0; j < sublist.size(); j++) {

                combinations += (firstList.size() * sublist.get(j).size());

            }
        }

        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }

    private static boolean secondListContainsAnyOfFirst(List<Integer> firstList, List<Integer> secondList){
        boolean contain = false;
        for(int f : firstList) {
            if(secondList.contains(f)){
                contain = true;
                break;
            }
        }
        return contain;
    }

    private static boolean finalListContainsList(List<List<Integer>> finalList, List<Integer> list) {
        boolean finalContains = false;
        for(List<Integer> integerList: finalList){
            boolean contains = false;
            for(int i : list) {
                if (integerList.contains(i)) {
                    contains = true;
                    break;
                }
            }
            if(contains){
                finalContains = true;
                break;
            }
        }
        return finalContains;
    }
}
