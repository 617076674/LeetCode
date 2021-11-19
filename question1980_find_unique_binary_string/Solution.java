package question1980_find_unique_binary_string;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public String findDifferentBinaryString(String[] nums) {
    Set<Integer> set = new HashSet<>();
    for (String num : nums) {
      set.add(Integer.parseInt(num, 2));
    }
    for (int i = 0; i < Math.pow(2, nums.length); i++) {
      if (set.contains(i)) {
        continue;
      }
      String result = Integer.toBinaryString(i);
      while (result.length() < nums.length) {
        result = "0" + result;
      }
      return result;
    }
    return null;
  }

}