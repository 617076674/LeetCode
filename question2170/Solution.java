package question2170;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int minimumOperations(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }
    Map<Integer, Integer> map1 = new HashMap<>();
    int count1 = 0;
    for (int i = 0; i < nums.length; i += 2) {
      map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
      count1++;
    }
    Map<Integer, Integer> map2 = new HashMap<>();
    int count2 = 0;
    for (int i = 1; i < nums.length; i += 2) {
      map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
      count2++;
    }
    Integer[] nums1 = new Integer[map1.entrySet().size()];
    int index = 0;
    for (int num : map1.keySet()) {
      nums1[index++] = num;
    }
    Arrays.sort(nums1, (o1, o2) -> map1.get(o2) - map1.get(o1));
    Integer[] nums2 = new Integer[map2.keySet().size()];
    index = 0;
    for (int num : map2.keySet()) {
      nums2[index++] = num;
    }
    Arrays.sort(nums2, (o1, o2) -> map2.get(o2) - map2.get(o1));
    if (nums1[0] != nums2[0]) {
      return count1 - map1.get(nums1[0]) + count2 - map2.get(nums2[0]);
    }
    int result = Math.min(count1 + count2 - map2.get(nums2[0]), count2 + count1 - map1.get(nums1[0]));
    if (nums1.length > 1) {
      result = Math.min(result, count1 - map1.get(nums1[1]) + count2 - map2.get(nums2[0]));
    }
    if (nums2.length > 1) {
      result = Math.min(result, count1 - map1.get(nums1[0]) + count2 - map2.get(nums2[1]));
    }
    return result;
  }

}