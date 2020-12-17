package question1664_ways_to_make_a_fair_array;

public class Solution {
  public int waysToMakeFair(int[] nums) {
    int[] oddSum = new int[nums.length + 1];    // oddSum[i] 表示 [0, i - 1] 范围内的奇数和
    for (int i = 1; i < oddSum.length; i++) {
      oddSum[i] = oddSum[i - 1];
      if ((i & 1) == 0) {
        oddSum[i] += nums[i - 1];
      }
    }
    int[] evenSum = new int[nums.length + 1];   // evenSum[i] 表示 [0, i - 1] 范围内的偶数和
    for (int i = 1; i < evenSum.length; i++) {
      evenSum[i] = evenSum[i - 1];
      if ((i & 1) == 1) {
        evenSum[i] += nums[i - 1];
      }
    }
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (oddSum[i] + evenSum[nums.length] - evenSum[i + 1] == evenSum[i] + oddSum[nums.length] - oddSum[i + 1]) {
        result++;
      }
    }
    return result;
  }
}