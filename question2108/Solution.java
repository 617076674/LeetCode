package question2108;

public class Solution {

  public String firstPalindrome(String[] words) {
    for (String word : words) {
      if (isPalindrome(word)) {
        return word;
      }
    }
    return "";
  }

  private boolean isPalindrome(String s) {
    for (int i = 0; i <= s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}
