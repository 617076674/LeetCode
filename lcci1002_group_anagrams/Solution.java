package lcci1002_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> list = map.get(key);
      if (null == list) {
        list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      } else {
        list.add(str);
      }
    }
    return new ArrayList<>(map.values());
  }

}