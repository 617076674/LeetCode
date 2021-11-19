package question1985_find_the_kth_largest_integer_in_the_array;

import java.util.Arrays;

public class Solution {

  public String kthLargestNumber(String[] nums, int k) {
      int len = 0;
      for (String num : nums) {
          len = Math.max(len, num.length());
      }
      for (int i = 0; i < nums.length; i++) {
          StringBuilder sb = new StringBuilder(nums[i]);
          while (sb.length() < len) {
              sb.insert(0, "0");
          }
          nums[i] = sb.toString();
      }
      Arrays.sort(nums);
      String result = nums[nums.length - k];
      while (result.length() > 1 && result.charAt(0) == '0') {
          result = result.substring(1);
      }
      return result;
  }
  
}