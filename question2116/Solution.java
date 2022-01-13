package question2116;

public class Solution {

  public boolean canBeValid(String s, String locked) {
    if (s.length() % 2 == 1) {
      return false;
    }
    int countLeft = 0, countRight = 0, countAny = 0;
    for (int i = 0; i < s.length(); i++) {
      if (locked.charAt(i) == '0') {
        countAny++;
      } else if (s.charAt(i) == '(') {
        countLeft++;
      } else {
        countRight++;
      }
      if (countRight > countAny + countLeft) {
        return false;
      }
    }
    countLeft = 0;
    countRight = 0;
    countAny = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (locked.charAt(i) == '0') {
        countAny++;
      } else if (s.charAt(i) == '(') {
        countLeft++;
      } else {
        countRight++;
      }
      if (countLeft > countAny + countRight) {
        return false;
      }
    }
    return true;
  }

}