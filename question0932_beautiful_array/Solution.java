package question0932_beautiful_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private Map<Integer, int[]> memo = new HashMap<>();

  public int[] beautifulArray(int N) {
    return beautifulArrayHelper(N);
  }

  public int[] beautifulArrayHelper(int N) {
    int[] result = memo.get(N);
    if (null != result) {
      return result;
    }
    result = new int[N];
    if (N == 1) {
      result[0] = 1;
    } else {
      int i = 0;
      // 左半部分是奇数
      for (int num : beautifulArrayHelper((N + 1) / 2)) {
        result[i++] = 2 * num - 1;
      }
      // 右半部分是偶数
      for (int num : beautifulArrayHelper(N / 2)) {
        result[i++] = 2 * num;
      }
    }
    memo.put(N, result);
    return result;
  }

}