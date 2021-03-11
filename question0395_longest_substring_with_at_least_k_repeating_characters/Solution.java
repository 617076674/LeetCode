package question0395_longest_substring_with_at_least_k_repeating_characters;

/**
 * 分治算法。
 *
 * 时间复杂度是O(nlogn)，其中n是字符串s的长度。空间复杂度是O(logn)。
 * 
 * 执行用时：1ms，击败75.54%。消耗内存：40.7MB，击败5.07%。
 */
public class Solution {

  public int longestSubstring(String s, int k) {
    int n;
    if (null == s || (n = s.length()) == 0 || k > n) {
      return 0;
    }
    if (k == 1) {
      return n;
    }
    return longestSubstring(s, k, 0, n - 1);
  }

  private int longestSubstring(String s, int k, int left, int right) {
    if (right - left + 1 < k) {
      return 0;
    }
    int[] count = new int[26];
    for (int i = left; i <= right; i++) {
      count[s.charAt(i) - 'a']++;
    }
    while (right - left + 1 > k && count[s.charAt(left) - 'a'] < k) {
      left++;
    }
    while (right - left + 1 > k && count[s.charAt(right) - 'a'] < k) {
      right--;
    }
    for (int i = left; i < right; i++) {
      if (count[s.charAt(i) - 'a'] < k) {
        return Math.max(longestSubstring(s, k, left, i - 1), longestSubstring(s, k, i + 1, right));
      }
    }
    return right - left + 1;
  }

}