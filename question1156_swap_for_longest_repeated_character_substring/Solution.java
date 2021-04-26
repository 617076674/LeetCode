package question1156_swap_for_longest_repeated_character_substring;

public class Solution {

  public int maxRepOpt1(String text) {
    int len = text.length();
    int[] map = new int[26];
    //统计26个小写字母各自出现的次数
    for (int i = 0; i < len; i++) {
      map[text.charAt(i) - 'a']++;
    }
    char lastChar = text.charAt(0);
    int temp = 1, result = 1;
    for (int i = 1; i < len; i++) {
      if (lastChar != text.charAt(i)) {
        int tempIdx = i;
        while (tempIdx + 1 < len && lastChar == text.charAt(tempIdx + 1)) {
          temp++;
          tempIdx++;
        }
        if (map[lastChar - 'a'] > temp) {
          temp++;
        }
        result = Math.max(result, temp);
        temp = 1;
        lastChar = text.charAt(i);
      } else {
        temp++;
      }
    }
    // 处理 acbaaa 这种特殊情况
    if (temp > 1 && map[lastChar - 'a'] > temp) {
      temp++;
    }
    return Math.max(result, temp);
  }

}