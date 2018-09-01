package question004;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/81805795
 */
public class Solution2 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int mid1 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, (n1 + n2) / 2 + 1);
		if((n1 + n2) % 2 != 0) {
			return mid1;
		}else {
			int mid2 = findKthInTwoArrays(nums1, 0, n1 - 1, nums2, 0, n2 - 1, (n1 + n2) / 2);
			return 0.5 * (mid1 + mid2);
		}
	}

	/*
	 * 寻找两个有序数组nums1数组中[left1, right1]范围内和nums2数组[left2, right2]范围内第k小的数，k从1开始计数
	 */
	private int findKthInTwoArrays(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
		int n1 = right1 - left1 + 1;
		int n2 = right2 - left2 + 1;
		if(k > n1 + n2) {
			throw new IllegalArgumentException("The input k is too big!");
		}
		/*if(n1 > n2) {
			return findKthInTwoArrays(nums2, left2, right2, nums1, left1, right1, k);
		}*/
		if(n1 == 0) {
			return nums2[left2 + k - 1];
		}
		if(k == 1) {
			return Math.min(nums1[left1], nums2[left2]);
		}
		int i = Math.min(n1, k / 2);
		int j = Math.min(n2, k / 2);
		if(nums1[left1 + i - 1] > nums2[left2 + j - 1]) {
			return findKthInTwoArrays(nums1, left1, right1, nums2, left2 + j, right2, k - j);
		}else {
			return findKthInTwoArrays(nums1, left1 + i, right1, nums2, left2, right2, k - i);
		}
	}
}
