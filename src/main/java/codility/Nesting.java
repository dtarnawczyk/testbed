package codility;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Nesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(solution("(()))"));
		
	}
	
	public static int solution(String S){
		Deque<Character> stack = new ArrayDeque<>();
		
		Map<Character, Character> closings = new HashMap();
		closings.put(')', '(');
		
		for(char s : S.toCharArray()) {
			if(closings.containsKey(s)){
				if(closings.get(s) == stack.peek()) {
					stack.pop();
				} else {
					stack.push(s);
				}
			} else {
				stack.push(s);
			}
		}
		
		if(stack.isEmpty()){
			return 1;
		} else {
			return 0;
		}
		
	}

}
