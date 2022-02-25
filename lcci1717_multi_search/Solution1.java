package lcci1717_multi_search;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP
 */
public class Solution1 {

  public int[][] multiSearch(String big, String[] smalls) {
    int[][] result = new int[smalls.length][];
    for (int i = 0; i < smalls.length; i++) {
      List<Integer> list = search(big, smalls[i]);
      result[i] = new int[list.size()];
      for (int j = 0; j < list.size(); j++) {
        result[i][j] = list.get(j);
      }
    }
    return result;
  }

  private static List<Integer> search(String big, String small) {
    List<Integer> result = new ArrayList<>();
    if (small.isEmpty()) {
      return result;
    }
    int[] next = getNext(small);
    int start = 0;
    while (start < big.length()) {
      int idx = search(big, start, small, next);
      if (idx == -1) {
        break;
      }
      result.add(idx);
      start = idx + 1;
    }
    return result;
  }

  // 在字符串 s 中 [start, s.length() - 1] 范围内寻找第一个 p 出现的位置
  private static int search(String s, int start, String p, int[] next) {
    int j = 0;
    for (int i = start; i < s.length(); i++) {
      if (p.charAt(j) == s.charAt(i)) {
        j++;
      } else {
        while (j > 0 && p.charAt(j) != s.charAt(i)) {
          j = next[j - 1];
        }
        if (p.charAt(j) == s.charAt(i)) {
          j++;
        }
      }
      if (j == p.length()) {
        return i - j + 1;
      }
    }
    return -1;
  }

  private static int[] getNext(String p) {
    int[] next = new int[p.length()];
    for (int i = 1; i < next.length; i++) {
      if (p.charAt(i) == p.charAt(next[i])) {
        next[i] = next[i - 1] + 1;
      } else {
        int j = next[i];
        while (j > 0 && p.charAt(i) != p.charAt(j)) {
          j = next[j - 1];
        }
        if (p.charAt(i) == p.charAt(j)) {
          next[i] = j + 1;
        }
      }
    }
    return next;
  }

}