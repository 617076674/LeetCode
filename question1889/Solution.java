package question1889;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1000000007;

  public int minWastedSpace(int[] packages, int[][] boxes) {
    Arrays.sort(packages);
    long[] sums = new long[packages.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + packages[i - 1];
    }
    for (int i = 0; i < boxes.length; i++) {
      Arrays.sort(boxes[i]);
    }
    long result = Long.MAX_VALUE;
    for (int i = 0; i < boxes.length; i++) {
      int preCeilIndex = -1;
      long tempExtra = 0L;
      for (int j = 0; j < boxes[i].length; j++) {
        int ceilIndex = ceil(packages, preCeilIndex + 1, packages.length - 1, boxes[i][j]);
        if (ceilIndex != -1) {
          tempExtra += 1L * (ceilIndex - preCeilIndex) * boxes[i][j] - (sums[ceilIndex + 1] - sums[preCeilIndex + 1]);
        }
        if (ceilIndex == packages.length - 1 && tempExtra < result) {
          result = tempExtra;
          break;
        }
        preCeilIndex = ceilIndex;
      }
    }
    return result == Long.MAX_VALUE ? -1 : (int) (result % MOD);
  }

  public static void main(String[] args) {
//    int[] packages = {2,3,5};
    int[] packages = {3,5,8,10,11,12};
//    int[][] boxes = {{4,8},{2,8}};
    int[][] boxes = {{12},{11,9},{10,5,14}};
//    int[][] boxes = {{1,4},{2,3},{2,4}};
    System.out.println(new Solution().minWastedSpace(packages, boxes));
  }
  private static int ceil(int[] nums, int left, int right, int target) {
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
    return right;
  }

}