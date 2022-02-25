package lcci1718_shortest_supersequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int[] shortestSeq(int[] big, int[] small) {
    Set<Integer> smallSet = new HashSet<>();
    for (int num : small) {
      smallSet.add(num);
    }
    Map<Integer, Integer> window = new HashMap<>();
    int left = 0, right = -1, minLen = big.length + 1, resultIdx = -1;
    while (right + 1 < big.length) {
      right++;
      if (smallSet.contains(big[right])) {
        window.put(big[right], window.getOrDefault(big[right], 0) + 1);
      }
      while (left <= right && window.keySet().size() == smallSet.size()) {
        int tempLen = right - left + 1;
        if (tempLen < minLen) {
          minLen = tempLen;
          resultIdx = left;
        }
        if (smallSet.contains(big[left])) {
          int leftValCnt = window.get(big[left]);
          if (1 == leftValCnt) {
            window.remove(big[left]);
          } else {
            window.put(big[left], leftValCnt - 1);
          }
        }
        left++;
      }
    }
    if (resultIdx == -1) {
      return new int[] {};
    }
    return new int[] {resultIdx, resultIdx + minLen - 1};
  }

}