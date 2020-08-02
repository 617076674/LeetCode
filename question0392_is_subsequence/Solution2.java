package question0392_is_subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
//  public boolean isSubsequence(String s, String t) {
//    if (s.length() > t.length()) {
//      return false;
//    }
//    Map<Character, List<Integer>> map = new HashMap<>();
//    for (int i = 0; i < t.length(); i++) {
//      char c = t.charAt(i);
//      if (!map.containsKey(c)) {
//        map.put(c, new ArrayList<>());
//      }
//      map.get(c).add(i);
//    }
//    int index1 = 0, index2 = 0;
//    while (index1 < s.length()) {
//      char c = s.charAt(index1);
//      index2 = ceil(map.get(c), index2);
//      if (index2 >= t.length()) {
//        return false;
//      }
//      index1++;
//    }
//    return true;
//  }
//
//  /**
//   * 在有序列表 list 中寻找大于 index 的第一个数
//   */
//  private int ceil(List<Integer> list, int index) {
//    int left = 0, right = list.size() - 1;
//    while (left < right) {
//      int mid = left + (right - left) / 2;
//      if (list.get(mid) > index) {
//        right =
//      }
//    }
//  }
}
