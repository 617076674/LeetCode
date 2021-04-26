package question1343_number_of_sub_arrays_of_size_k_and_average_greater_than_or_equal_to_threshold;

public class Solution {

  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int[] sums = new int[arr.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + arr[i - 1];
    }
    int result = 0;
    for (int i = k - 1; i < arr.length; i++) {
      if (sums[i + 1] - sums[i + 1 - k] >= k * threshold) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {11,13,17,23,29,31,7,5,2,3};
    System.out.println(new Solution().numOfSubarrays(arr, 3, 5));
  }

}