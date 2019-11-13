package question0004_median_of_two_sorted_arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 寻找第k个数和第k - 1个数。
 *
 * 时间复杂度是O(n)，其中n为nums1数组的长度和nums2数组的长度总和。空间复杂度是O(1)。
 *
 * 执行用时：12ms，击败86.12%。消耗内存：52.8MB，击败69.61%。
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
        //如果n是一个偶数，比如n1 = 2，n2 = 2，那么中位数是索引为1和2的两个数的平均
        //如果n是一个奇数，比如n1 = 1，n2 = 2，那么中位数是索引为1的数
        //无论是奇数还是偶数，我们寻找索引为(n / 2)的那个数，同时记录其前一个数，当n是偶数时需要用到
        int i = 0, j = 0, index = 0, pre = -1, cur = -1;
        while (index < ((n >> 1) + 1)) {
            pre = cur;
            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i >= n1 && j < n2) {
                cur = nums2[j++];
            } else if (i < n1) {
                cur = nums1[i++];
            }
            index++;
        }
        if ((n & 1) == 0) {
            return (cur + pre) * 0.5;
        }
        return cur;
    }
}