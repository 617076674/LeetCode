package question1818_minimum_absolute_sum_difference;

import java.util.TreeSet;

public class Solution {

    private static int MOD = 1000000007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1) {
            treeSet.add(num);
        }
        long gapSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            gapSum += Math.abs(nums1[i] - nums2[i]);
        }
        long result = gapSum;
        for (int i = 0; i < nums1.length; i++) {
            Integer ceil = treeSet.ceiling(nums2[i]), floor = treeSet.floor(nums2[i]);
            int less = 0;
            if (null != ceil) {
                if (nums1[i] >= nums2[i]) {
                    less = nums1[i] - ceil;
                } else {
                    less = Math.max(0, Math.abs(nums2[i] - nums1[i]) - Math.abs(ceil - nums2[i]));
                }
            }
            if (null != floor) {
                if (nums1[i] <= nums2[i]) {
                    less = Math.max(less, floor - nums1[i]);
                } else {
                    less = Math.max(less, Math.max(0, Math.abs(nums2[i] - nums1[i]) - Math.abs(floor - nums2[i])));
                }
            }
            result = Math.min(result, gapSum - less);
        }
        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,28,21};
        int[] nums2 = {9,21,20};
        System.out.println(new Solution().minAbsoluteSumDiff(nums1, nums2));
    }

}