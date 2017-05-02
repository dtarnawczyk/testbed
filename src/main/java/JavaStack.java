
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input=sc.next();
			char [] chars = input.toCharArray();
			char closing1 = ')';
			char closing2 = '}';
			char closing3 = ']';
			Map <Character, Character> pars = new HashMap();
			pars.put('(', closing1);
			pars.put('{', closing2);
			pars.put('[', closing3);

			if(chars.length % 2 == 0) {
				boolean correct = checkPairs(chars, pars);
				System.out.println(correct);
			} else {
				System.out.println(false);	
			}

		}

		sc.close();
	}

	private static boolean checkPairs(char [] chars, Map <Character, Character> pars) {
		Deque<Character> stack = new ArrayDeque<Character>(chars.length);
		boolean correct = true;
		for(int i=chars.length-1; i >= 0; i--) {
			stack.push(chars[i]);
		}

		while(stack.size() > 1) {
			char first = stack.getFirst();
			char last = stack.getLast();
			if (pars.containsKey(first)){
				char mirrorfirst = pars.get(stack.getFirst());
				if (mirrorfirst == last) {
					stack.removeFirst();
					stack.removeLast();
				} else {
					char [] firstHalf = Arrays.copyOfRange(chars, 0, chars.length/2);
					char [] secondHalf = Arrays.copyOfRange(chars, chars.length / 2, chars.length);
					if(!checkPairs(firstHalf, pars) || !checkPairs(secondHalf, pars)){
						correct = false;
					} 
					break;
					
				}
			} else {
				if (pars.containsKey(last)){
					char lastMirror = pars.get(last);
					if (first == lastMirror) {
						stack.removeFirst();
						stack.removeLast();
					} else {
						correct = false;
						break;
					}
				} else {
					correct = false;
					break;
				}
			}
		}
		return correct;
	}
}

