package question0848_shifting_letters;

public class Solution {

  public String shiftingLetters(String S, int[] shifts) {
    int[] sum = new int[shifts.length + 1];
    for (int i = shifts.length - 1; i >= 0; i--) {
      sum[i] = (shifts[i] + sum[i + 1]) % 26;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      int shift = i <= shifts.length ? sum[i] : 0;
      sb.append((char) (((S.charAt(i) + shift - 'a') % 26 + 'a')));
    }
    return sb.toString();
  }

}