package lcp28_4xy4Wx;

public class Solution {

  private static int MOD = 1000000007;

  public int purchasePlans(int[] nums, int target) {
    int[] map = new int[100001];
    for (int num : nums) {
      map[num]++;
    }
    int i = 0, j = 0;
    while (i < nums.length) {
      while (map[j] == 0) {
        j++;
      }
      while (map[j] > 0) {
        nums[i] = j;
        map[j]--;
        i++;
      }
    }
    long result = 0;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      while (right > left && nums[left] + nums[right] > target) {
        right--;
      }
      result = (result + right - left) % MOD;
      left++;
    }
    return (int) result;
  }

}