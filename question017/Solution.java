package question017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177357
 */
public class Solution {
	
	private List<String> list;
	private HashMap<Character, String> hashMap;
	
	public List<String> letterCombinations(String digits) {
		list = new ArrayList<>();
		if(digits.length() == 0) {
			return list;
		}
		hashMap = new HashMap<>();
		hashMap.put('2', "abc");
		hashMap.put('3', "def");
		hashMap.put('4', "ghi");
		hashMap.put('5', "jkl");
		hashMap.put('6', "mno");
		hashMap.put('7', "pqrs");
		hashMap.put('8', "tuv");
		hashMap.put('9', "wxyz");
		StringBuilder stringBuilder = new StringBuilder();
		letterCombinations(digits, 0, stringBuilder);
		return list;
	}
	
	private void letterCombinations(String digits, int index, StringBuilder stringBuilder) {
		if(index == digits.length()) {
			list.add(stringBuilder.toString());
			return;
		}
		char[] nextChar = hashMap.get(digits.charAt(index)).toCharArray();
		for(int i = 0; i < nextChar.length; i++) {
			stringBuilder.append(nextChar[i]);
			letterCombinations(digits, index + 1, stringBuilder);
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
	}
}
