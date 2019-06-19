package question0004;

/**
 * 二分查找法。
 *
 * 时间复杂度和空间复杂度均是O(log(n1 + n2))，其中n1是nums1数组的长度，n2是nums2数组的长度。
 *
 * 执行用时：13ms，击败71.43%。消耗内存：50.3MB，击败78.50%。
 */
public class Solution2 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		int target = ((n1 + n2) >> 1) + 1;
		int mid1 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target);
		if(((n1 + n2) & 1) != 0) {
			return mid1;
		}
		int mid2 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, target - 1);
		return 0.5 * (mid1 + mid2);
	}
	/**
	 * 在nums1数组[left1, right1]范围内，以及nums2数组[left2, right2]范围内，寻找第k小数
	 */
	private int findKthInTwoArrays(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
		int n1 = right1 - left1 + 1, n2 = right2 - left2 + 1;
		if (n1 > n2) {
			return findKthInTwoArrays(nums2, left2, right2, nums1, left1, right1, k);
		}
		if(n1 == 0) {
			return nums2[left2 + k - 1];
		}
		if(k == 1) {
			return Math.min(nums1[left1], nums2[left2]);
		}
		int i = Math.min(n1, k / 2), j = Math.min(n2, k / 2);
		if(nums1[left1 + i - 1] > nums2[left2 + j - 1]) {
			return findKthInTwoArrays(nums1, left1, right1, nums2, left2 + j, right2, k - j);
		}
		return findKthInTwoArrays(nums1, left1 + i, right1, nums2, left2, right2, k - i);
	}
}
