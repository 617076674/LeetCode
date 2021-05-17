package question1471_the_k_strongest_values_in_an_array;

import java.util.Arrays;

public class Solution2 {

  public int[] getStrongest(int[] arr, int k) {
    int[] target = new int[k];
    Arrays.sort(arr);
    int index = 0, mid = arr[(arr.length - 1) / 2], left = 0, right = arr.length - 1;
    while (index < k) {
      if (Math.abs(arr[left] - mid) > Math.abs(arr[right] - mid)) {
        target[index++] = arr[left++];
      } else {
        target[index++] = arr[right--];
      }
    }
    return target;
  }

}