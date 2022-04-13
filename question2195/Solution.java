package question2195;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public long minimalKSum(int[] nums, int k) {
    Set<Integer> numsSet = new HashSet<>();
    for (int num : nums) {
      numsSet.add(num);
    }
    nums = new int[numsSet.size()];
    int index = 0;
    for (int num : numsSet) {
      nums[index++] = num;
    }
    Arrays.sort(nums);
    long[] sums = new long[nums.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + nums[i - 1];
    }
    if (k < nums[0]) {
      return (1L + k) * k / 2;
    }
    long left = 1, right = k + nums.length + 1;
    while (left <= right) {
      long mid = (left + right) / 2;
      int cnt = ceil(nums, mid);
      if (mid - cnt < k) {
        left = mid + 1;
      } else if (mid - cnt > k) {
        right = mid - 1;
      } else {
        return (1 + mid) * mid / 2 - sums[cnt];
      }
    }
    return -1;
  }

  // 寻找 nums 数组中小于等于 target 的元素共有多少个
  private static int ceil(int[] nums, long target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left >= 0 && left < nums.length && nums[left] <= target) {
      return left + 1;
    }
    if (right >= 0 && right < nums.length && nums[right] <= target) {
      return right + 1;
    }
    return 0;
   }

}