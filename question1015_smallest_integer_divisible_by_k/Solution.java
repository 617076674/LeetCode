package question1015_smallest_integer_divisible_by_k;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int smallestRepunitDivByK(int K) {
    if (K % 2 == 0 || K % 5 == 0) {
      return -1;
    }
    Set<Integer> set = new HashSet<>();
    int r = 0;
    for (int i = 1; ; i++) {
      r = (r * 10 + 1) % K;
      if (r == 0) {
        return i;
      }
      if (set.contains(r)) {
        return -1;
      }
      set.add(r);
    }
  }

}