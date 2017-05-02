package codility;

public class BinarySearch {

	public static void main(String [] args) {

		System.out.println(binarySearch(new int[]{3, 1, 5, 7, 3, 2, 4, 8}, 6));
	}

	public static boolean binarySearch(int [] searchTable, int searchValue){
		// create even elements table (by adding zero if odd)
		searchTable = setTableWithEvenAndSortedElements(searchTable);
		// sorting
		sort(searchTable);

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
        return searchTable[start] == searchValue;
	}

	private static int [] setTableWithEvenAndSortedElements(int [] table){
		// fill with zero if not odd
		if ( (table.length % 2 ) != 0){
			int [] tempSearchTable = new int[table.length+1];
			for(int i=0; i < tempSearchTable.length-1; i++){
				tempSearchTable[i] = table[i];
			}
			tempSearchTable[tempSearchTable.length-1] = 0;
			table = tempSearchTable;
		}

		return table;
	}

	public static int [] sort(int [] unsorted) {

		for(int a = unsorted.length; a >= 0; a--){	
			for(int i = 0; i < (unsorted.length-1); i++){
				int tmp = unsorted[i];
				if(unsorted[i] > unsorted[i+1]){
					unsorted[i] = unsorted[i+1];
					unsorted[i+1] = tmp;
				}
			}			
		}		

		return unsorted; 

	}
}