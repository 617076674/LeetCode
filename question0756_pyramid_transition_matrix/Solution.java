package question0756_pyramid_transition_matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  private Map<String, List<Character>> map = new HashMap<>();

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    for (String rule : allowed) {
      String key = rule.substring(0, 2);
      List<Character> list = map.get(key);
      if (null == list) {
        List<Character> temp = new ArrayList<>();
        temp.add(rule.charAt(2));
        map.put(key, temp);
      } else {
        list.add(rule.charAt(2));
      }
    }
    return pyramidTransition(bottom);
  }

  private boolean pyramidTransition(String bottom) {
    if (bottom.length() == 1) {
      return true;
    }
    Set<String> set = new HashSet<>();
    for (int i = 0; i < bottom.length() - 1; i++) {
      List<Character> list = map.get(bottom.substring(i, i + 2));
      if (null == list) {
        return false;
      }
      Set<String> temp = new HashSet<>();
      for (Character c : list) {
        if (i == 0) {
          temp.add("" + c);
        } else {
          for (String s : set) {
            temp.add(s + c);
          }
        }
      }
      set = temp;
    }
    for (String s : set) {
      if (pyramidTransition(s)) {
        return true;
      }
    }
    return false;
  }

}