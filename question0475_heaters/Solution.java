package question0475_heaters;

import java.util.Arrays;

public class Solution {

  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int result = 0;
    for (int house : houses) {
      int ceilIndex = ceil(heaters, house), floorIndex = floor(heaters, house);
      int tempResult = Integer.MAX_VALUE;
      if (ceilIndex != heaters.length) {
        tempResult = Math.min(tempResult, heaters[ceilIndex] - house);
      }
      if (floorIndex != -1) {
        tempResult = Math.min(tempResult, house - heaters[floorIndex]);
      }
      result = Math.max(result, tempResult);
    }
    return result;
  }

  private static int ceil(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (right >= 0 && right < nums.length && nums[right] == target) {
      return right;
    }
    return left;
  }

  private static int floor(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        right = mid - 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left >= 0 && left < nums.length && nums[left] == target) {
      return left;
    }
    return right;
  }

}