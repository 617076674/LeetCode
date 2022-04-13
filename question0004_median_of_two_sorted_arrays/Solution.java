package question0004_median_of_two_sorted_arrays;

public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    if ((n1 + n2) % 2 == 0) {
      // 偶数个，取中间 2 个数的平均值为中位数
      int index1 = (n1 + n2) / 2;
      int index2 = index1 - 1;
      int num1 = findKth(nums1, 0, n1 - 1, nums2, 0, n2 - 1, index1);
      int num2 = findKth(nums1, 0, n1 - 1, nums2, 0, n2 - 1, index2);
      return (num1 + num2) / 2.0;
    } else {
      int index = (n1 + n2) / 2;
      return 1.0 * findKth(nums1, 0, n1 - 1, nums2, 0, n2 - 1, index);
    }
  }

  private int findKth(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2,
                      int index) {
    if (left1 > right1) {
      return nums2[left2 + index];
    }
    if (left2 > right2) {
      return nums1[left1 + index];
    }
    if (index == 0) {
      return Math.min(nums1[left1], nums2[left2]);
    }
    int mid1 = Math.min(right1, left1 + index / 2 + 1);
    int mid2 = Math.min(right2, left2 + index / 2 + 1);
    if (nums1[mid1] > nums2[mid2]) {
      if (mid1 - left1 + 1 + mid2 - left2 + 1 > index + 1) {
        return findKth(nums1, left1, mid1 - 1, nums2, left2, right2, index);
      }
      return findKth(nums1, left1, mid1, nums2, mid2 + 1, right2, index - (mid2 - left2 + 1));
    }
    if (mid1 - left1 + 1 + mid2 - left2 + 1 > index + 1) {
      return findKth(nums1, left1, right1, nums2, left2, mid2 - 1, index);
    }
    return findKth(nums1, mid1 + 1, right1, nums2, left2, mid2, index - (mid1 - left1 + 1));
  }

}