package question1611_minimum_one_bit_operations_to_make_integers_zero;

/**
 * 找规律。
 * 当 n == 2 ^ 0 时，1 -> 0，操作 1 步。
 * 当 n == 2 ^ 1 时，10 -> 11 -> 01 -> 00，操作 3 步。
 * 当 n == 2 ^ 2 时，100 -> 101 -> 111 -> 110 -> 010 -> 011 -> 001 -> 000，操作 7 步。
 * 当 n == 2 ^ 3 时，1000 -> 1001 -> 1011 -> 1010 -> 1110 -> 1111 -> 1101 -> 1100 -> 0100 -> 0101 -> 0111 -> 0110 -> 0010 -> 0011 -> 0001 -> 0000，操作 15 步。
 * ……
 * 当 n 是 2 的 i 次方数时，从 n 转化到 0，需要经过 (2 ^ (i + 1)) - 1 步。
 *
 * 当 n 不是 2 的幂次方数时，比如 n 为 10，即 (2 ^ 3 + 2 ^ 1) 时，需要走 12 ，即 (15 - 3) 步。
 *
 * 当 n 为 11，即 (2 ^ 3 + 2 ^ 1 + 2 ^ 0) 时，需要走 13，即 (15 - 3 + 1) 步。
 *
 * 当 n 为 9，即 (2 ^ 3 + 2 ^ 0) 时，需要走 14，即 (15 - 1) 步。
 *
 * 时间复杂度和空间复杂度均是 O(1)。
 *
 * 执行用时：1ms，击败64.88%。消耗内存：35.7MB，击败68.36%。
 */
public class Solution {

  public int minimumOneBitOperations(int n) {
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[32];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = (int) (Math.pow(2, i + 1) - 1);
    }
    boolean positive = true;
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      if (((n >> i) & 1) == 1) {
        if (positive) {
          result += dp[i];
        } else {
          result -= dp[i];
        }
        positive ^= true;
      }
    }
    return result;
  }

}