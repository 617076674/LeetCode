package question0890_find_and_replace_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (match(word, pattern)) {
        result.add(word);
      }
    }
    return result;
  }

  public boolean match(String word, String pattern) {
    Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char w = word.charAt(i);
      char p = pattern.charAt(i);
      if (!map1.containsKey(w)) {
        map1.put(w, p);
      }
      if (!map2.containsKey(p)) {
        map2.put(p, w);
      }
      if (map1.get(w) != p || map2.get(p) != w) {
        return false;
      }
    }
    return true;
  }

}