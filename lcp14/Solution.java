package lcp14;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int splitArray(int[] nums) {
    int[] minPrime = new int[1000000 + 1];

    for (int i = 2; i < minPrime.length; i++) {
      if (minPrime[i] < 2) {
        for (int j = i; j < minPrime.length; j += i) {
          minPrime[j] = i;
        }
      }
    }
    int[] ans = new int[nums.length];
    Map<Integer, Integer> primeMinIndex = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      ans[i] = i > 0 ? ans[i - 1] + 1 : 1;
      while (n > 1) {
        int factor = minPrime[n];
        int minIndex;
        if (primeMinIndex.containsKey(factor)) {
          minIndex = primeMinIndex.get(factor);
        } else {
          minIndex = i;
          primeMinIndex.put(factor, minIndex);
        }
        if (minIndex > 0) {
          ans[i] = Math.min(ans[i], ans[minIndex - 1] + 1);
        } else {
          ans[i] = 1;
        }
        if (ans[i] < ans[minIndex]) {
          primeMinIndex.put(factor, i);
        }
        n = n / factor;
      }
    }
    return ans[nums.length - 1];
  }

}