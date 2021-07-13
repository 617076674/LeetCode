package question1927_sum_game;

public class Solution {

  public boolean sumGame(String num) {
    int num1 = 0, num2 = 0, count1 = 0, count2 = 0, i = 0;
    for (; i < num.length() / 2; i++) {
      if (num.charAt(i) == '?') {
        count1++;
      } else {
        num1 += num.charAt(i) - '0';
      }
    }
    for (; i < num.length(); i++) {
      if (num.charAt(i) == '?') {
        count2++;
      } else {
        num2 += num.charAt(i) - '0';
      }
    }
    if (((count1 + count2) & 1) == 1) {
      return true;
    }
    if (num1 > num2) {
      if (count1 >= count2) {
        return true;
      }
      return (count2 - count1) / 2 * 9 + num2 != num1;
    }
    if (num1 == num2) {
      return count1 != count2;
    }
    if (count1 <= count2) {
      return true;
    }
    return (count1 - count2) / 2 * 9 + num1 != num2;
  }

}