package question1879;

public class Solution {

  private Integer[][] memo;

  public int minimumXORSum(int[] nums1, int[] nums2) {
    memo = new Integer[nums1.length][1 << nums2.length];
    return minimumXORSumHelper(nums1, nums2, nums1.length - 1, (1 << nums2.length) - 1);
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2}, nums2 = {2,3};
    System.out.println(new Solution().minimumXORSum(nums1, nums2));
  }

  private int minimumXORSumHelper(int[] nums1, int[] nums2, int index, int status) {
    if (status == 0) {
      return 0;
    }
    if (memo[index][status] != null) {
      return memo[index][status];
    }
    int result = Integer.MAX_VALUE / 2;
    for (int i = 0; i < 32; i++) {
      if ((status & (1 << i)) != 0) {
        status ^= (1 << i);
        result = Math.min(result, (nums1[index] ^ nums2[i]) + minimumXORSumHelper(nums1, nums2, index - 1, status));
        status ^= (1 << i);
      }
    }
    memo[index][status] = result;
    return result;
  }

}