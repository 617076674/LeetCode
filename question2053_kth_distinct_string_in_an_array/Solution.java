package question2053_kth_distinct_string_in_an_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String kthDistinct(String[] arr, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : arr) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    int index = 1;
    for (String s : arr) {
        if (map.get(s) == 1) {
            if (index == k) {
                return s;
            }
            index++;
        }
    }
    return "";
  }

}