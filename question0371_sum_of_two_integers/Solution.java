package question0371_sum_of_two_integers;

/**
 * 利用位运算。
 */
public class Solution {

  public int getSum(int a, int b) {
    while (b != 0) {
      int sum = a ^ b, carry = (a & b) << 1;
      a = sum;
      b = carry;
    }
    return a;
  }

}