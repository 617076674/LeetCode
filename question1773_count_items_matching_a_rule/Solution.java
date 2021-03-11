package question1773_count_items_matching_a_rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    Map<String, Integer> typeMap = new HashMap<>(),
        colorMap = new HashMap<>(),
        nameMap = new HashMap<>();
    for (List<String> item : items) {
        typeMap.put(item.get(0), typeMap.getOrDefault(item.get(0), 0) + 1);
        colorMap.put(item.get(1), colorMap.getOrDefault(item.get(1), 0) + 1);
        nameMap.put(item.get(2), nameMap.getOrDefault(item.get(2), 0) + 1);
    }
    if ("type".equals(ruleKey)) {
        return typeMap.getOrDefault(ruleValue, 0);
    } else if ("color".equals(ruleKey)) {
        return colorMap.getOrDefault(ruleValue, 0);
    }
    return nameMap.getOrDefault(ruleValue, 0);
  }

}