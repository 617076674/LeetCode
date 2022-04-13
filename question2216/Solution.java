package question2216;

public class Solution {

  public int minDeletion(int[] nums) {
    int res = 0;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (index % 2 == 0) {
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          // 需要删除第 i 个元素
          res++;
          i++;
        }
      }
      index++;
    }
    if (index % 2 == 1) {
      res++;
    }
    return res;
  }

}