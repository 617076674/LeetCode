package question1035_uncrossed_lines;

public class Solution {

    private Integer[][] memo;

    public int maxUncrossedLines(int[] A, int[] B) {
        memo = new Integer[A.length][B.length];
        return maxUncrossedLines(A, 0, B, 0);
    }

    private int maxUncrossedLines(int[] nums1, int index1, int[] nums2, int index2) {
        if (index1 >= nums1.length || index2 >= nums2.length) {
            return 0;
        }
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        if (nums1[index1] == nums2[index2]) {
            memo[index1][index2] = 1 +
                maxUncrossedLines(nums1, index1 + 1, nums2, index2 + 1);
        } else {
            memo[index1][index2] =
                Math.max(maxUncrossedLines(nums1, index1 + 1, nums2, index2),
                    maxUncrossedLines(nums1, index1, nums2, index2 + 1));
        }
        return memo[index1][index2];
    }

}