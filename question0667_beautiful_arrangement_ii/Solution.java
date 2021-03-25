package question0667_beautiful_arrangement_ii;

public class Solution {

  public int[] constructArray(int n, int k) {
    int[] result = new int[n];
    result[0] = 1;
    int i = 1;
    for (; i < n && k > 0; i++, k--) {
      if ((i & 1) == 0) {
        result[i] = result[i - 1] - k;
      } else {
        result[i] = result[i - 1] + k;
      }
    }
    for (; i < n; i++) {
      result[i] = i + 1;
    }
    return result;
  }

}