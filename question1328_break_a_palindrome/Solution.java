package question1328_break_a_palindrome;

public class Solution {

  public String breakPalindrome(String palindrome) {
    if (palindrome.length() == 1) {
      return "";
    }
    for (int i = 0; i < palindrome.length() / 2; i++) {
      if (palindrome.charAt(i) != 'a') {
        return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
      }
    }
    for (int i = palindrome.length() - 1; i >= 0; i--) {
      if (palindrome.charAt(i) == 'a') {
        return palindrome.substring(0, i) + "b" + palindrome.substring(i + 1);
      }
    }
    return "";
  }

}