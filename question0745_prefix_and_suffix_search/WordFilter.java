package question0745_prefix_and_suffix_search;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

  private Map<String, Map<String, Integer>> map = new HashMap<>();

  public WordFilter(String[] words) {
    for (int i = 0; i < words.length; i++) {
      for (int j = 1; j <= words[i].length(); j++) {
        String prefix = words[i].substring(0, j);
        for (int k = 0; k < words[i].length(); k++) {
          String suffix = words[i].substring(k);
          Map<String, Integer> suffixMap = map.get(prefix);
          if (null == suffixMap) {
            suffixMap = new HashMap<>();
            suffixMap.put(suffix, i);
            map.put(prefix, suffixMap);
          } else {
            suffixMap.put(suffix, i);
          }
        }
      }
    }
  }

  public int f(String prefix, String suffix) {
    Map<String, Integer> suffixMap = map.get(prefix);
    if (null == suffixMap) {
      return -1;
    }
    Integer index = suffixMap.get(suffix);
    return index == null ? -1 : index;
  }

}