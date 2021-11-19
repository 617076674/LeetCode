package question2032_two_out_of_three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
    Set<Integer> set1 = getSet(nums1), set2 = getSet(nums2), set3 = getSet(nums3),
        result = new HashSet<>();
    add(result, nums1, set2, set3);
    add(result, nums2, set1, set3);
    add(result, nums3, set1, set2);
    return new ArrayList<>(result);
  }

  private static void add(Set<Integer> result, int[] nums, Set<Integer> set1, Set<Integer> set2) {
    for (int num : nums) {
      if (set1.contains(num) || set2.contains(num)) {
        result.add(num);
      }
    }
  }

  private static Set<Integer> getSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    return set;
  }

}