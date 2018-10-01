package question049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> listList = new ArrayList<>();
		HashMap<String, List<String>> hashMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] array = strs[i].toCharArray();
			Arrays.sort(array);
			String tempString = String.valueOf(array);
			if(hashMap.containsKey(tempString)) {
				hashMap.get(tempString).add(strs[i]);
			}else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				hashMap.put(tempString, list);
			}
		}
		for (String string : hashMap.keySet()) {
			listList.add(hashMap.get(string));
		}
		return listList;
	}
}
