package question0719_find_k_th_smallest_pair_distance;

import java.util.Arrays;

/**
 * 二分 + 滑动窗口法
 */
public class Solution2 {

  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    //将数组排序
    //设置最小值，和理论最大值
    int low = 0, high = nums[nums.length - 1] - nums[0];
    while (low < high) {
      int count = 0;
      int mid = low + (high - low) / 2;
      int left = 0;
      //求此时差值小于等于 mid 的个数与k值进行比较。
      for (int right = 0; right < nums.length; right++) {
        while (nums[right] - nums[left] > mid) {
          //差值大于 mid 时收缩左边界
          left++;
        }
        count += right - left;
      }
      if (count >= k) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

}