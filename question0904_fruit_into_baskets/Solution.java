package question0904_fruit_into_baskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int totalFruit(int[] tree) {
    int left = 0, right = -1, result = 0;
    Map<Integer, Integer> type2RightIndex = new HashMap<>();
    while (right + 1 < tree.length) {
      right++;
      if (!type2RightIndex.containsKey(tree[right])) {
        if (type2RightIndex.size() == 2) {
          int removedType = tree[left];
          left = type2RightIndex.get(removedType) + 1;
          for (Map.Entry<Integer, Integer> entry : type2RightIndex.entrySet()) {
            if (entry.getValue() + 1 < left) {
              left = entry.getValue() + 1;
              removedType = entry.getKey();
            }
          }
          type2RightIndex.remove(removedType);
        }
        type2RightIndex.put(tree[right], right);
      } else {
        type2RightIndex.put(tree[right], right);
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

}