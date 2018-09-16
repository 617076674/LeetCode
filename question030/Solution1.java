package question030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82432440
 */
public class Solution1 {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(words.length == 0) {
			return result;
		}
		//num represents the length of words array
		int num = words.length;
		//len represents the length of words[0]
		int len = words[0].length();
		//Create a hashMap whose key are Strings in words array and values are there appearance times in words array
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < num; i++) {
			if(hashMap.containsKey(words[i])) {
				hashMap.put(words[i], hashMap.get(words[i]) + 1);
			}else {
				hashMap.put(words[i], 1);
			}
		}
		for(int i = 0; i < s.length() - num * len + 1; i++) {
			HashMap<String, Integer> tempMap = new HashMap<>(hashMap);
			int j = 0;
			for(; j < words[0].length() * num; j += words[0].length()) {
				String subString = s.substring(i + j, i + j + len);
				if(!tempMap.containsKey(subString)) {
					break;
				}else {
					tempMap.put(subString, tempMap.get(subString) - 1);
					if(tempMap.get(subString) == 0) {
						tempMap.remove(subString);
					}
				}
			}
			if(j >= len * num) {
				result.add(i);
			}
		}
		return result;
	}
}
