package codility;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Brackets {

	public static void main(String[] args) {
		
		System.out.println(solution("()()()"));

	}
	
	public static int solution(String str) {
		char [] chars = str.toCharArray();
		
		char closing1 = ')';
		char closing2 = '}';
		char closing3 = ']';
		Map <Character, Character> pars = new HashMap();
		pars.put(closing1, '(');
		pars.put(closing2, '{');
		pars.put(closing3, '[');
		
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i=0; i < chars.length; i++) {
			
			if (pars.containsKey(chars[i])) {
				
				if (pars.get(chars[i]) == stack.peek()) {
					stack.pop();	
				} else {
					stack.push(chars[i]);
				}
				
			} else {
				
				stack.push(chars[i]);
			
			}
						
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
}
