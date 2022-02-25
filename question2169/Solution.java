package question2169;

public class Solution {

  public int countOperations(int num1, int num2) {
    int step = 0;
    while (true) {
      if (num1 == 0 || num2 == 0) {
        return step;
      }
      if (num1 >= num2) {
        num1 -= num2;
      } else {
        num2 -= num1;
      }
      step++;
    }
  }

}