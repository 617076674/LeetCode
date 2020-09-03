package question0201_bitwise_and_of_numbers_range;

/**
 * 时间复杂度是 O(logn)。空间复杂度是 O(1)。
 *
 * 执行用时：6ms，击败99.82%。消耗内存：39MB，击败76.01%。
 */
public class Solution2 {
  public int rangeBitwiseAnd(int m, int n) {
    while (m < n) {
      // 抹去最右边的 1
      n = n & (n - 1);
    }
    return n;
  }
}