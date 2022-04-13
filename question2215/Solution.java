package question2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = array2Set(nums1), set2 = array2Set(nums2);
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> resSet1 = new HashSet<>();
    for (int num1 : nums1) {
      if (!set2.contains(num1)) {
        resSet1.add(num1);
      }
    }
    res.add(new ArrayList<>(resSet1));
    Set<Integer> resSet2 = new HashSet<>();
    for (int num2 : nums2) {
      if (!set1.contains(num2)) {
        resSet2.add(num2);
      }
    }
    res.add(new ArrayList<>(resSet2));
    return res;
  }

  private static Set<Integer> array2Set(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    return set;
  }

}