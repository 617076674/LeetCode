package question1332_remove_palindromic_subsequences;

public class Solution {

  public int removePalindromeSub(String s) {
    if (null == s || s.length() == 0) {
      return 0;
    }
    return isPalindrome(s) ? 1 : 2;
  }

  private boolean isPalindrome(String s) {
    for (int i = 0; i < (s.length() >> 1); i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}