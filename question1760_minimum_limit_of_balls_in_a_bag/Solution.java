package question1760_minimum_limit_of_balls_in_a_bag;

public class Solution {

  public int minimumSize(int[] nums, int maxOperations) {
      int left = 1, right = nums[0];
      for (int i = 1; i < nums.length; i++) {
          right = Math.max(right, nums[i]);
      }
      while (left < right) {
          if (left + 1 == right) {
              if (check(nums, left, maxOperations)) {
                  return left;
              }
              return right;
          }
          int mid = left + ((right - left) >> 1);
          if (check(nums, mid, maxOperations)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }

  private static boolean check(int[] nums, int target, int maxOperations) {
      int operations = 0;
      for (int num : nums) {
          if (num > target) {
              operations += num / target;
              if (num % target == 0) {
                  operations--;
              }
              if (operations > maxOperations) {
                  return false;
              }
          }
      }
      return true;
  }

}