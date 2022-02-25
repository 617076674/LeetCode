package question0969_pancake_sorting;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> pancakeSort(int[] arr) {
    List<Integer> result = new ArrayList<>();
    int n = arr.length;
    for (int i = n - 1; i > 0; i--) {
      // arr[i] 应该放置的数是 (i + 1)
      if (arr[i] == i + 1) {
        continue;
      }
      int j = 0;
      for (; j < i; j++) {
        if (i + 1 == arr[j]) {
          break;
        }
      }
      if (j + 1 > 1) {
        reverse(arr, j + 1);
        result.add(j + 1);
      }
      reverse(arr, i + 1);
      result.add(i + 1);
    }
    return result;
  }

  private static void reverse(int[] nums, int k) {
    int left = 0, right = k - 1;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}