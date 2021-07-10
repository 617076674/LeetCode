package question0451_sort_characters_by_frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    List<Character> list = new ArrayList<>(map.keySet());
    Collections.sort(list, (c1, c2) -> map.get(c2) - map.get(c1));
    StringBuilder sb = new StringBuilder();
    for (Character c : list) {
      for (int i = 0; i < map.get(c); i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}