package question0004_median_of_two_sorted_arrays;

public class Solution3 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int target = (nums1.length + nums2.length) / 2;
    if ((nums1.length + nums2.length) % 2 == 0) {
      return (findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1,
          target) + findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1
          , target - 1)) / 2;
    }
    return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1,
        target);
  }

  // 在 nums1 数组 [left1, right1] 范围内，以及 nums2 数组 [left2, right2] 范围内寻找第 k 个数，k 从 0 开始计数
  private static double findMedianSortedArrays(int[] nums1, int left1, int right1, int[] nums2,
                                               int left2, int right2, int k) {
    if (left1 > right1) {
      return nums2[left2 + k];
    }
    if (left2 > right2) {
      return nums1[left1 + k];
    }
    if (k == 0) {
      return Math.min(nums1[left1], nums2[left2]);
    }
    // [left1, left1 + k / 2], [left1 + k / 2 + 1, right1]
    // [left2, left2 + k / 2], [left2 + k / 2 + 1, right2]
    int mid1 = Math.min(left1 + (k - 1) / 2, right1);
    int mid2 = Math.min(left2 + (k - 1) / 2, right2);
    // [left1, mid1], [mid1 + 1, right1]
    // [left2, mid2], [mid2 + 1, right2];
    if (nums1[mid1] > nums2[mid2]) {
      return findMedianSortedArrays(nums1, left1, right1, nums2, mid2 + 1, right2,
          k - (mid2 - left2 + 1));
    }
    if (nums1[mid1] < nums2[mid2]) {
      return findMedianSortedArrays(nums1, mid1 + 1, right1, nums2, left2, right2,
          k - (mid1 - left1 + 1));
    }
    if ((mid2 - left2 + 1) + (mid1 - left1 + 1) <= k) {
      return findMedianSortedArrays(nums1, mid1 + 1, right1, nums2, mid2 + 1, right2,
          (k - (mid1 - left1 + 1) - (mid2 - left2 + 1)));
    }
    return nums1[mid1];
  }

}