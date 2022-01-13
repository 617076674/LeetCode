package question0825_friends_of_appropriate_ages;

import java.util.Arrays;

public class Solution2 {

  public int numFriendRequests(int[] ages) {
    Arrays.sort(ages);
    int result = ages.length * (ages.length - 1);
    for (int i = 0; i < ages.length; i++) {
      // [i + 1, ages.length - 1]
      int target = (int) (0.5 * ages[i] + 7);
      if (i != ages.length - 1) {
        int ceilIndex1 = ceil(ages, i + 1, ages.length - 1, ages[i]);
        if (ceilIndex1 < ages.length && ages[ceilIndex1] == ages[i]) {
          ceilIndex1++;
        }
        // [ceilIndex1, age.length - 1] 范围内的数字符合要求
        result -= ages.length - ceilIndex1;
        if (i + 1 <= ceilIndex1 - 1) {
          int ceilIndex2 = ceil(ages, i + 1, ceilIndex1 - 1, target);
          if (ceilIndex2 == ceilIndex1 || ages[ceilIndex2] != target) {
            ceilIndex2--;
          }
          // [i + 1, ceilIndex2]
          result -= ceilIndex2 - i;
        }
      }
      if (i == 0) {
        continue;
      }
      int ceilIndex = ceil(ages, 0, i - 1, target);
      if (ceilIndex == i || ages[ceilIndex] != target) {
        ceilIndex--;
      }
      // [0, ceilIndex] 范围内的数字符合要求
      result -= ceilIndex + 1;
    }
    return result;
  }

  private static int ceil(int[] nums, int numsLeft, int numsRight, int target) {
    int left = numsLeft, right = numsRight;
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
    if (right >= numsLeft && right <= numsRight && nums[right] == target) {
      return right;
    }
    return left;
  }

}