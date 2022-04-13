package question2234;

import java.util.Arrays;

public class Solution {

  private long[] sums;

  private int target;

  private int full;

  private int partial;

  private int[] flowers;

  public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
    this.flowers = flowers;
    this.target = target;
    this.full = full;
    this.partial = partial;
    Arrays.sort(flowers);
    sums = new long[flowers.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + flowers[i - 1];
    }
    int perfect = 0;
    for (int i = 0; i < flowers.length; i++) {
      if (flowers[i] >= target) {
        perfect++;
      }
    }
    long remained = newFlowers;
    long res = Long.MIN_VALUE;
    for (int i = perfect; i <= flowers.length; i++) {
      // 有 i 朵花是美丽的
      // [0, n - i - 1] 是不美丽的 [n - i, n - 1] 是美丽的
      // 还有 remained 朵花
      res = Math.max(res, maxScore(i, remained));
      // 把 [n - i - 1] 变成美丽
      if (i == flowers.length) {
        break;
      }
      remained -= target - flowers[flowers.length - i - 1];
      if (remained < 0) {
        break;
      }
    }
    return res;
  }

  private long maxScore(int fullCnt, long newFlowers) {
    if (fullCnt == flowers.length) {
      return 1L * fullCnt * full;
    }
    int left = flowers[0];
    int right = target - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (check(fullCnt, newFlowers, mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    //[right, left]
    if (left <= target - 1 && left >= flowers[0] && check(fullCnt, newFlowers, left)) {
      return full * 1L * fullCnt + left * 1L * partial;
    }
    return full * 1L * fullCnt + right * 1L * partial;
  }

  // [0, n - fullCnt - 1] 填满成 level
  private boolean check(int fullCnt, long newFlowers, int level) {
    int ceilIndex = ceil(flowers, flowers.length - fullCnt - 1, level);
    if (ceilIndex == -1) {
      // 所有的 flowers 都比 level 要小
      return sums[flowers.length - fullCnt] + newFlowers >= level * 1L * (flowers.length - fullCnt);
    }
    // [0, Math.min(n - fullCnt - 1, ceilIndex - 1)] 范围内的值 比 level 要小
    return sums[ceilIndex] + newFlowers >= level * 1L * ceilIndex;
  }

  private static int ceil(int[] nums, int rightWall, int target) {
    int left = 0, right = rightWall;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    // [right, left]
    if (right >= 0 && right <= rightWall && nums[right] >= target) {
      return right;
    }
    if (left >= 0 && left <= rightWall && nums[left] >= target) {
      return left;
    }
    return -1;
  }

}