package question2193;

/**
 * 贪心+模拟。
 */
public class Solution1 {

  public int minMovesToMakePalindrome(String s) {
    return minMovesToMakePalindrome(s.toCharArray(), 0, s.length() - 1);
  }

  private static int minMovesToMakePalindrome(char[] s, int left, int right) {
    if (left >= right) {
      return 0;
    }
    if (s[left] == s[right]) {
      return minMovesToMakePalindrome(s, left + 1, right - 1);
    }
    int anotherIdx = right;
    while (anotherIdx >= left) {
      if (s[anotherIdx] == s[left]) {
        break;
      }
      anotherIdx--;
    }
    if (anotherIdx == left) {
      char temp = s[left];
      s[left] = s[left + 1];
      s[left + 1] = temp;
      return 1 + minMovesToMakePalindrome(s, left, right);
    }
    char temp = s[anotherIdx];
    System.arraycopy(s, anotherIdx + 1, s, anotherIdx, right - anotherIdx);
    s[right] = temp;
    return right - anotherIdx + minMovesToMakePalindrome(s, left + 1, right - 1);
  }

}