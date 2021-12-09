package question2091;

public class Solution {

  public int minimumDeletions(int[] nums) {
    int minIndex = 0, maxIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[minIndex]) {
        minIndex = i;
      }
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }
    // 都从头移除
    int result = Math.max(minIndex, maxIndex) + 1;
    // 都从尾移除
    result = Math.min(result, Math.max(nums.length - minIndex, nums.length - maxIndex));
    // 小坐标从头移除，大坐标从尾移除
    int temp1 = Math.min(minIndex, maxIndex), temp2 = Math.max(minIndex, maxIndex);
    result = Math.min(result, temp1 + 1 + nums.length - temp2);
    return result;
  }

}