package question1471_the_k_strongest_values_in_an_array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1 {

  public int[] getStrongest(int[] arr, int k) {
    int mid = findKthLargest(arr, 0, arr.length - 1, arr.length - (arr.length + 1) / 2 + 1);
    PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> {
      if (Math.abs(num1 - mid) == Math.abs(num2 - mid)) {
        return num1 - num2;
      }
      return Math.abs(num1 - mid) - Math.abs(num2 - mid);
    });
    for (int num : arr) {
      pq.add(num);
      while (pq.size() > k) {
        pq.poll();
      }
    }
    int[] result = new int[k];
    int index = 0;
    while (!pq.isEmpty()) {
      result[index++] = pq.poll();
    }
    return result;
  }

  private int findKthLargest(int[] nums, int left, int right, int k) {
    if (left == right && k == 1) {
      return nums[left];
    }
    swap(nums, left, (int) (left + 1 + Math.random() * (right - left)));
    // [left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
    int lessThan = left, i = left + 1, greaterThan = right + 1;
    while (i < greaterThan) {
      if (nums[i] == nums[left]) {
        i++;
      } else if (nums[i] < nums[left]) {
        swap(nums, i, --greaterThan);
      } else {
        swap(nums, i++, ++lessThan);
      }
    }
    // [left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    swap(nums, lessThan--, left);
    // [left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    if (k <= lessThan - left + 1) {
      return findKthLargest(nums, left, lessThan, k);
    } else if (k >= greaterThan - left + 1) {
      return findKthLargest(nums, greaterThan, right, k - greaterThan + left);
    }
    return nums[lessThan + 1];
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}