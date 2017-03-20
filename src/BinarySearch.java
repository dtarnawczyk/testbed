import java.util.Arrays;

/**
 * Created by dominik on 2017-02-03.
 */
public class BinarySearch {

//    public static boolean found = false;

    public static void main(String [] args) {

        System.out.println(binarySearch(new int[]{3}, 3));
    }

    public static boolean binarySearch(int [] searchTable, int searchValue){

        searchTable = setTableWithEvenAndSortedElements(searchTable);
        // sorting
        Arrays.sort(searchTable);
        //
//        found = false;
        int start = 0;
        int end = searchTable.length;

        while (start < end) {
            int middle = (start+end) / 2;
            if(searchTable[middle] < searchValue){
                start = middle+1;
            } else {
                end = middle;
            }
        }
        if(searchTable[start] == searchValue){
            return true;
        }else{
            return false;
        }
    }

    private static int [] setTableWithEvenAndSortedElements(int [] table){
        // fill with zero if not odd
        if ( (table.length%2 ) != 0){
            int [] tempSearchTable = new int[table.length+1];
            for(int i=0; i < tempSearchTable.length-1; i++){
                tempSearchTable[i] = table[i];
            }
            tempSearchTable[tempSearchTable.length-1] = 0;
            table = tempSearchTable;
        }

        return table;
    }
}
