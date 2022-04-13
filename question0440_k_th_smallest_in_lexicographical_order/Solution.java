package question0440_k_th_smallest_in_lexicographical_order;

public class Solution {

  public int findKthNumber(int n, int k) {
    int cur = 1;
    k--;
    while (k > 0) {
      int count = getCount(cur, n);
      if (count <= k) {
        k -= count;
        cur = cur + 1;
      } else {
        cur = cur * 10;
        k--;
      }
    }
    return cur;
  }

  // 当前节点下有多少个数是小于等于 n 的
  private static int getCount(long cur, long n) {
    int result = 0;
    long first = cur, last = cur;
    while (first <= n) {
      result += Math.min(last, n) - first + 1;
      first = first * 10;
      last = last * 10 + 9;
    }
    return result;
  }

}