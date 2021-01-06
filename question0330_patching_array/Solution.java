package question0330_patching_array;

/**
 * https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
 */
public class Solution {

  public int minPatches(int[] nums, int n) {
    int result = 0, index = 0;
    long x = 1;
    while (x <= n) {
      if (index < nums.length && nums[index] <= x) {
        x += nums[index];
        index++;
      } else {
        x *= 2;
        result++;
      }
    }
    return result;
  }

}