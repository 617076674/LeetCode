package question2014_longest_subsequence_repeated_k_times;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子序列长度最多为 7，故而可以暴力找出长度为 7 以内的序列作为要找的子序列，依次验证即可。
 */
public class Solution {

  public String longestSubsequenceRepeatedK(String s, int k) {
    List<String>[] results = new List[8]; // results[i] 表示长度为 i 的符合条件的子序列
    for (int i = 0; i < results.length; i++) {
      results[i] = new ArrayList<>();
    }
    results[0].add("");
    int i = 1;
    for (; i < results.length; i++) {
      for (String pre : results[i - 1]) {
        for (int j = 0; j < 26; j++) {
          char c = (char) ('a' + j);
          if (check(s, pre + c, k)) {
              results[i].add(pre + c);
          }
        }
      }
      if (results[i].isEmpty()) {
          break;
      }
    }
    Collections.sort(results[i - 1]);
    return results[i - 1].get(results[i - 1].size() - 1);
  }

  private static boolean check(String s, String sub, int k) {
    int index1 = 0, index2 = 0;
    while (index1 < s.length()) {
        if (s.charAt(index1) == sub.charAt(index2)) {
            index1++;
            index2++;
        } else {
            index1++;
        }
        if (index2 == sub.length()) {
            k--;
            if (k == 0) {
                return true;
            }
            index2 = 0;
        }
    }
    return false;
  }

}