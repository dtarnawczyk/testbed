import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiddlePermutation {

    public static void main(String[] args) {
        System.out.println(findMidPerm("unqkmzvte"));
        System.out.println(findMidPerm("rlpmfu"));
        System.out.println(findMidPerm("sefqhpm"));
        System.out.println(findMidPerm("asektvwrgylcqzumxpijfdn"));
    }

    public static String findMidPerm(String strng) {

        char [] letters = strng.toCharArray();
        List<String> permutations = new ArrayList<>();
        permutation(letters, permutations);
        Collections.sort(permutations);
        return (permutations.size() % 2) == 0 ? permutations.get((permutations.size() / 2) - 1) :
                permutations.get(permutations.size() /2);
    }

    private static void permutation(char [] array, List<String> permutations) {
        generate(array, array.length-1, permutations);
    }

    private static void generate(char [] array, int n, List<String> permutations){
        if(n == 0){
            permutations.add(new String(array));
        } else {
            for(int i=0; i <= n; i++){
                generate(array, n-1, permutations);
                if(i < n) {
                    swap(array, i, n);
                    reverse(array, n-1);
                }
            }
        }
    }

    private static void reverse(char [] array, int m){
        int n = m;
        int i = 0;
        while(i < n){
            swap(array, i, n);
            i++;
            n--;
        }
    }

    private static void swap(char [] array, int index1, int index2){
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

//    @Test
//    public void basicTests() {
//        assertEquals("bac", MiddlePermutation.findMidPerm("abc"));
//        assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
//        assertEquals("cbxda", MiddlePermutation.findMidPerm("abcdx"));
//        assertEquals("cxgdba", MiddlePermutation.findMidPerm("abcdxg"));
//        assertEquals("dczxgba", MiddlePermutation.findMidPerm("abcdxgz"));
//    }
}
