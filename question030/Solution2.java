package question030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82432440
 */
public class Solution2 {
	
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
		for(int i = 0; i < len; i++) {
			//floating window[left, right - 1]
			HashMap<String, Integer> window = new HashMap<>();
			int left = i;
			int right = i;
			while(right < s.length() - len + 1 && left < s.length() - len * num + 1) {
				String subStringRight = s.substring(right, right + len);
				if(!hashMap.containsKey(subStringRight)) {
					right += len;
					left = right;
					window.clear();
					continue;
				}
				if(!window.containsKey(subStringRight)) {
					window.put(subStringRight, 1);	
				}else {
					window.put(subStringRight, window.get(subStringRight) + 1);					
				}
				right += len;	
				while(window.get(subStringRight) > hashMap.get(subStringRight)) {
					String subStringLeft = s.substring(left, left + len);
					window.put(subStringLeft, window.get(subStringLeft) - 1);
					if(window.get(subStringLeft) == 0){
						window.remove(subStringLeft);
					}
					left += len;
				}
				if(right - left == num * len) {
					result.add(left);
				}
			}
		}
		return result;
	}
}
