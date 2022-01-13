package question1614;

public class Solution {

  public int maxDepth(String s) {
    int result = 0;
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else if (s.charAt(i) == ')') {
        left--;
      }
      result = Math.max(result, left);
    }
    return result;
  }

}