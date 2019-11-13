package question0004_median_of_two_sorted_arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 二分查找法。
 *
 * 时间复杂度和空间复杂度均是O(log(n1 + n2))，其中n1是nums1数组的长度，n2是nums2数组的长度。
 *
 * 执行用时：13ms，击败71.43%。消耗内存：50.3MB，击败78.50%。
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2, target = (n >> 1) + 1;
        int mid1 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target);
        if ((n & 1) != 0) {
            return mid1;
        }
        int mid2 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target - 1);
        return 0.5 * (mid1 + mid2);
    }

    /**
     * 在nums1数组[left1, right1]范围内，以及nums2数组[left2, right2]范围内，寻找第k小数（k从1开始计数）
     */
    private int findKthInTwoArrays(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        //n1记录[left1, right1]范围内的元素个数，n2记录[left2, right2]范围内的元素个数
        int n1 = right1 - left1 + 1, n2 = right2 - left2 + 1;
        if (n1 > n2) {  //为了便于后续处理，我们假设n1小于等于n2
            return findKthInTwoArrays(nums2, left2, right2, nums1, left1, right1, k);
        }
        if (n1 == 0) {  //如果n1为0，直接返回nums2数组中的索引为(left2 + k - 1)处的元素
            return nums2[left2 + k - 1];
        }
        if (k == 1) {   //如果k为1，寻找的是最小数，直接返回nums1[left1]和nums2[left2]中的较小者
            return Math.min(nums1[left1], nums2[left2]);
        }
        int i = Math.min(n1, k / 2), j = Math.min(n2, k / 2);   //这么取i和j是为了防止(left1 + i)和(left2 + j)越界
        //将nums1数组中[left1, right1]范围内的元素分成2部分，其索引范围分别是[left1, left1 + i - 1]，[left1 + i, right1]
        //将nums2数组中[left2, right2]范围内的元素分成2部分，其索引范围分别是[left2, left2 + j - 1], [left2 + j, right2]
        //再次明确一下这个递归函数的作用：在nums1数组[left1, right1]范围内，以及nums2数组[left2, right2]范围内，寻找第k小数
        if (nums1[left1 + i - 1] > nums2[left2 + j - 1]) {
            //如果说nums[left1 + i - 1] > nums2[left2 + j - 1]，[left2, left2 + j - 1]范围内的元素均比nums1[left1 + i - 1]小
            //这些元素已经不可能是第k小数，这些元素的个数有j个，在排除这些元素的范围内继续寻找第(k - j)小数
            return findKthInTwoArrays(nums1, left1, right1, nums2, left2 + j, right2, k - j);
        }
        //nums[left1 + i - 1] <= nums2[left2 + j - 1]，[left1, left1 + i - 1]范围内的元素均小于等于nums2[left2 + j - 1]
        //这些元素已经不可能是第k小数，这些元素的个数有i个，在排除这些元素的范围内继续寻找第(k - i)小数
        return findKthInTwoArrays(nums1, left1 + i, right1, nums2, left2, right2, k - i);
    }
}