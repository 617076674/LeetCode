package question0349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }
    Set<Integer> resultSet = new HashSet<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        resultSet.add(num);
      }
    }
    int[] result = new int[resultSet.size()];
    int index = 0;
    for (int num : resultSet) {
      result[index++] = num;
    }
    return result;
  }

}