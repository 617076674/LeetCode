package lcp29_SNJvJP;

public class Solution {

  public int orchestraLayout(int num, int xPos, int yPos) {
    long x = xPos, y = yPos, n = num;
    if (x <= y) {
      long k = Math.min(x, n - 1 - y);
      return (int) ((4 * k * (n - k) + 1 + (x + y - k * 2) - 1) % 9 + 1);
    }
    long k = Math.min(y, n - 1 - x) + 1;
    return (int) ((4 * k * (n - k) + 1 - (x + y - (k - 1) * 2) - 1) % 9 + 1);
  }

}