package question0522_longest_uncommon_subsequence_ii;

public class Solution2 {

  public int findLUSlength(String[] strs) {
    int max = -1;
    for (int i = 0; i < strs.length; i++) {
      int j = 0;
      for (; j < strs.length; j++) {
        if (j != i && judge(strs[j], strs[i])) {
          break;
        }
      }
      if (j >= strs.length) {
        max = Math.max(max, strs[i].length());
      }
    }
    return max;
  }

  // 判断字符串 s2 是否是字符串 s1 的子串
  private boolean judge(String s1, String s2) {
    int index1 = 0, index2 = 0;
    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) == s2.charAt(index2)) {
        index1++;
        index2++;
      } else {
        index1++;
      }
    }
    return index2 >= s2.length();
  }

}