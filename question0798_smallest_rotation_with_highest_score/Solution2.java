package question0798_smallest_rotation_with_highest_score;

/**
 * 差分数组。
 *
 *    0        1          2          3           ...     i     ...      n - 1
 * nums[0]   nums[1]    nums[2]    nums[3]       ...  nums[i]  ...    nums[n - 1]
 *
 * 对于 nums[i] 分情况讨论
 * 如果 nums[i] > i，那么其左移 [0, i] 次时得到的分数为 0，左移 [i + 1, n - nums[i] + i] 次时得到的分数为 1，左移 [n - nums[i] + i + 1, n - 1] 次时得到的分数为 0。
 * 如果 nums[i] <= i，那么其左移 [0, i - nums[i]] 次时得到的分数为 1，左移 [i - nums[i] + 1, i] 次时得到的分数为 0，左移 [i + 1, n - 1] 次时得到的分数为 1。
 *
 * 用差分数组记录即可。
 */
public class Solution2 {

  public int bestRotation(int[] nums) {
    int[] diff = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > i) {
        diff[i + 1]++;
        diff[nums.length - nums[i] + i + 1]--;
      } else {
        diff[0]++;
        diff[i - nums[i] + 1]--;
        diff[i + 1]++;
      }
    }
    int maxScore = 0, result = 0, sum = 0;
    for (int k = 0; k < nums.length; k++) {
      sum += diff[k];
      if (sum > maxScore) {
        maxScore = sum;
        result = k;
      }
    }
    return result;
  }

}