package question0447_number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    for (int i = 0; i < points.length; i++) {
      Map<Integer, Integer> map = new HashMap<>();    //对每一个点i应该新建一个hashMap！！！
      for (int j = 0; j < points.length; j++) {
        if (i != j) {
          int len = distance(points[i], points[j]);
          map.put(len, map.getOrDefault(len, 0) + 1);
        }
      }
      for (Integer len : map.keySet()) {
        int num = map.get(len);
        if (num > 1) {
          count += num * (num - 1);
        }
      }
    }
    return count;
  }

  private int distance(int[] nums1, int[] nums2) {
    return (int) (Math.pow(nums1[0] - nums2[0], 2) + Math.pow(nums1[1] - nums2[1], 2));
  }

}