package question1492_the_kth_factor_of_n;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int kthFactor(int n, int k) {
    List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
    int sqrtN = (int) Math.sqrt(n);
    for (int i = 1; i < sqrtN; i++) {
      if (n % i == 0) {
        left.add(i);
        right.add(n / i);
      }
    }
    if (sqrtN * sqrtN == n) {
      left.add(sqrtN);
    } else if (n % sqrtN == 0) {
      left.add(sqrtN);
      right.add(n / sqrtN);
    }
    if (k <= left.size()) {
      return left.get(k - 1);
    }
    if (k <= left.size() + right.size()) {
      return right.get(right.size() - k + left.size());
    }
    return -1;
  }

}