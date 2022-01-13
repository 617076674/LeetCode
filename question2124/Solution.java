package question2124;

public class Solution {

  public boolean checkString(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) > s.charAt(i)) {
        return false;
      }
    }
    return true;
  }

}