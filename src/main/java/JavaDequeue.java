package javaDataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class JavaDequeue {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
         Deque deque = new ArrayDeque<>();
         int n = in.nextInt();
         int m = in.nextInt();
         for (int i = 0; i < n; i++) {
             int num = in.nextInt();
             deque.add(num);
         }
         int maxSize = 0;
         while(deque.size() > 0){
        	 Iterator<Integer> it = deque.iterator();
        	 Set<Integer> uniqueSet = new HashSet();
        	 int counter = m;
        	 while(it.hasNext()){
        		 if(counter > 0){
        			 uniqueSet.add(it.next());
        		 } else {
        			 break;
        		 }
        		 --counter;
        	 }
        	 int setSize = uniqueSet.size();
        	 if(setSize > maxSize) {
        		 maxSize = setSize;
        	 }
        	 deque.poll();
         }
         System.out.println(maxSize);
	}

}
