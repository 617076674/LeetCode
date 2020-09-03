package question0336_palindrome_pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表。
 *
 * 对于某个字符 s，将其拆分为两部分，s1 和 s2，其中 s1 是回文串，s2 不是回文串。
 *
 * 若 s = s1 + s2，那么只需要在 s 前面拼接上 s2 的逆序即可。
 * 若 s = s2 + s1，那么只需要在 s 后面拼接上 s2 的逆序即可。
 *
 * 对于 words 数组中的每一个字符串 words[i]，遍历所有的前缀和后缀回文串，并利用哈希表寻找 s2 的逆序。
 *
 * 时间复杂度是 O(n * m ^ 2)，其中 n 为数组 words 的长度，m 为字符串的平均长度。
 *
 * 执行用时：63ms，击败68.28%。消耗内存：41.4MB，击败86.67%。
 */
public class Solution2 {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
    }
    for (int i = 0; i < words.length; i++) {
      int m = words[i].length();
      for (int j = 0; j <= m; j++) {
        if (isPalindrome(words[i], j, m - 1)) {
          Integer leftId = map.get(new StringBuilder(words[i].substring(0, j)).reverse().toString());
          if (leftId != null && leftId != i) {
            result.add(Arrays.asList(i, leftId));
          }
        }
        if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
          Integer rightId = map.get(new StringBuilder(words[i].substring(j, m)).reverse().toString());
          if (rightId != null && rightId != i) {
            result.add(Arrays.asList(rightId, i));
          }
        }
      }
    }
    return result;
  }

  public boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
}