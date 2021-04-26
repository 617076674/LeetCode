package lcp33_o8SXZn;

public class Solution {

  public int storeWater(int[] bucket, int[] vat) {
    int max = 0;
    for (int v : vat) {
      if (max < v) {
        max = v;
      }
    }
    if (max == 0) {
      return 0;
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= 10000; i++) {
      int per, cur = i;
      for (int j = 0; j < bucket.length; j++) {
        per = vat[j] / i;
        if (vat[j] % i != 0) {
          per++;
        }
        cur += Math.max(0, per - bucket[j]);
      }
      result = Math.min(result, cur);
    }
    return result;
  }

}