package question020;

import java.util.Stack;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82250673
 */
public class Solution {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			Character character1 = s.charAt(i);
			if(character1 == '(' || character1 == '[' || character1 == '{') {
				stack.push(character1);
			}else if(character1 == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				Character character2 = stack.pop();
				if(character2 != '(') {
					return false;
				}
			}else if(character1 == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				Character character2 = stack.pop();
				if(character2 != '[') {
					return false;
				}
			}else if(character1 == '}') {
				if(stack.isEmpty()) {
					return false;
				}
				Character character2 = stack.pop();
				if(character2 != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
