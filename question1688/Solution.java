package question1688;

public class Solution {

  public int numberOfMatches(int n) {
    int result = 0;
    while (n > 1) {
      result += n / 2;
      n -= n / 2;
    }
    return result;
  }

}