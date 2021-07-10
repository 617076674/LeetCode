package question0719_find_k_th_smallest_pair_distance;

public class Solution1 {

  public int smallestDistancePair(int[] nums, int k) {
    int[] map = new int[1000000];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        map[Math.abs(nums[i] - nums[j])]++;
      }
    }
    for (int i = 0; i < map.length; i++) {
      if (k - map[i] <= 0) {
        return i;
      }
      k -= map[i];
    }
    return -1;
  }

}