package question2103;

public class Solution {

  public int countPoints(String rings) {
    int result = 0;
    boolean[] hasR = new boolean[10], hasG = new boolean[10], hasB = new boolean[10];
    for (int i = 0; i < rings.length(); i++) {
      char c = rings.charAt(i);
      int p = rings.charAt(i + 1) - '0';
      if (c == 'R') {
        hasR[p] = true;
      } else if (c =='G') {
        hasG[p] = true;
      } else {
        hasB[p] = true;
      }
      i++;
    }
    for (int i = 0; i < 10; i++) {
      if (hasR[i] && hasG[i] && hasB[i]) {
        result++;
      }
    }
    return result;
  }

}