package question1616_split_two_strings_to_make_palindrome;

public class Solution {

  public boolean checkPalindromeFormation(String a, String b) {
    if (isPalindrome(a, 0, a.length() - 1) || isPalindrome(b, 0, b.length() - 1)) {
      return true;
    }
    return checkPalindromeFormationHelper(a, b) || checkPalindromeFormationHelper(b, a);
  }

  private static boolean checkPalindromeFormationHelper(String s1, String s2) {
    int index1 = 0, index2 = s2.length() - 1;
    if (s1.charAt(index1) != s2.charAt(index2)) {
      return false;
    }
    while (s1.charAt(index1) == s2.charAt(index2)) {
      index1++;
      index2--;
    }
    return isPalindrome(s1, index1, index2) || isPalindrome(s2, index1, index2);
  }

  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}