import java.util.*;

public class SortByValueAndIndex {

    public static void main(String[] args) {

        sort(new int[]{9, 5, 1, 4, 3});
        sort(new int[]{26, 2, 3, 4, 5});
        sort(new int[]{23, 2, 3, 4, 5});

    }

    private static void sort(int [] array) {
        Set<Element> sortedSet = new TreeSet<>();
        for(int i=0; i < array.length; i++ ) {
            sortedSet.add(new Element(i, array[i], array[i] * (i+1)));
        }
        int [] newArray = new int[array.length];
        int counter = 0;
        for(Iterator<Element> it = sortedSet.iterator(); it.hasNext();){
            Element el = it.next();
            newArray[counter] = el.original;
            counter += 1;
        }
        System.out.println(Arrays.toString(newArray));
    }

    private static class Element implements Comparable<Element>{

        private int index = 0;
        private int original = 0;
        private int multi = 0;

        public Element(int index, int original, int multi){
            this.index = index;
            this.original = original;
            this.multi = multi;
        }

        @Override
        public int compareTo(Element element) {
            return Integer.compare(this.multi, element.multi);
//            if(this.multi > element.multi) {
//                return 1;
//            } else if(this.multi < element.multi) {
//                return -1;
//            }
//            return 0;
        }
    }

}

