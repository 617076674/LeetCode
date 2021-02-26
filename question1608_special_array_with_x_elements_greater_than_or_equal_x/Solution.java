package question1608_special_array_with_x_elements_greater_than_or_equal_x;

public class Solution {

  public int specialArray(int[] nums) {
    int[] count = new int[1001];
    for (int num : nums) {
      count[num]++;
    }
    int[] sums = new int[count.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + count[i - 1];
    }
    for (int i = 0; i <= nums.length; i++) {
      if (sums[sums.length - 1] - sums[i] == i) {
        return i;
      }
    }
    return -1;
  }
    
}