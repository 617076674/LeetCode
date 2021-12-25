package question2106;

public class Solution {

  public int maxTotalFruits(int[][] fruits, int startPos, int k) {
    long result = 0;
    long[] sums = new long[fruits.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + fruits[i - 1][1];
    }
    // sums[i] 表示 [0, i - 1] 索引内的水果数量
    for (int rightStep = 0; rightStep <= k; rightStep++) {
      // 向右走 rightStep 步
      // 向左走 leftStep 步
      int leftStep = Math.max(0, k - 2 * rightStep);
      int left = startPos - leftStep, right = startPos + rightStep;
      // fruits 数组中 [left, right] 范围内的水果有多少
      int floorIndex = floor(fruits, left), ceilIndex = ceil(fruits, right);
      result = Math.max(result, sums[ceilIndex + 1] - sums[floorIndex]);
    }
    for (int leftStep = 0; leftStep <= k; leftStep++) {
      // 向右走 rightStep 步
      // 向左走 leftStep 步
      int rightStep = Math.max(0, k - 2 * leftStep);
      int left = startPos - leftStep, right = startPos + rightStep;
      // fruits 数组中 [left, right] 范围内的水果有多少
      int floorIndex = floor(fruits, left), ceilIndex = ceil(fruits, right);
      result = Math.max(result, sums[ceilIndex + 1] - sums[floorIndex]);
    }
    return (int) result;
  }

  private static int ceil(int[][] fruits, int target) {
    int left = 0, right = fruits.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (fruits[mid][0] == target) {
        left = mid + 1;
      } else if (fruits[mid][0] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < fruits.length && left >= 0 && fruits[left][0] == target) {
      return left;
    }
    return right;
  }

  private static int floor(int[][] fruits, int target) {
    int left = 0, right = fruits.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (fruits[mid][0] == target) {
        right = mid - 1;
      } else if (fruits[mid][0] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (right < fruits.length && right >= 0 && fruits[right][0] == target) {
      return right;
    }
    return left;
  }

}
