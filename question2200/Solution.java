package question2200;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = Math.max(0, i - k); j <= Math.min(i + k, nums.length - 1); j++) {
        if (nums[j] == key) {
          res.add(i);
          break;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,2,2,2};
    int key = 2;
    int k = 2;
    System.out.println(new Solution().findKDistantIndices(nums, key, k));
  }

}