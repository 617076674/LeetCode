package question1846_maximum_element_after_decreasing_and_rearranging;

import java.util.Arrays;

public class Solution {

  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);
    arr[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] > 1) {
        arr[i] = arr[i - 1] + 1;
      }
    }
    return arr[arr.length - 1];
  }

  public static void main(String[] args) {
    int[] arr = {100, 1, 1000};
    System.out.println(new Solution().maximumElementAfterDecrementingAndRearranging(arr));
  }

}