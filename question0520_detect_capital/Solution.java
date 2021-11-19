package question0520_detect_capital;

public class Solution {

  public boolean detectCapitalUse(String word) {
    int n;
    if (null == word || (n = word.length()) == 0) {
      return true;
    }
    int count = 0;  //计算大写字母个数
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        count++;
      }
    }
    return count == n || count == 0 || (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
  }

}