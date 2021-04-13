package question0991_broken_calculator;

public class Solution {

  public int brokenCalc(int X, int Y) {
    int step = 0;
    while (Y > X) {
      step++;
      if (Y % 2 == 1) {
        Y++;
      } else {
        Y /= 2;
      }
    }
    return step + X - Y;
  }

}