package contest_12_12.question1;

public class Solution {

  public int countPoints(String rings) {
    int result = 0;
    boolean[] hasR = new boolean[10], hasG = new boolean[10], hasBlue = new boolean[10];
    for (int i = 0; i < rings.length(); i++) {
      char c = rings.charAt(i);
      int p = rings.charAt(i + 1) - '0';
      if (c == 'R') {
        hasR[p] = true;
      } else if (c =='G') {
        hasG[p] = true;
      } else {
        hasBlue[p] = true;
      }
      i++;
    }
    for (int i = 0; i < 10; i++) {
      if (hasR[i] && hasG[i] && hasBlue[i]) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().countPoints("B0B6G0R6R0R6G9"));
    System.out.println(new Solution().countPoints("B0R0G0R9R0B0G0"));
    System.out.println(new Solution().countPoints("G4"));
  }

}
