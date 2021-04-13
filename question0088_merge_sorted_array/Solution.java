package question0088_merge_sorted_array;

/**
 * 时间复杂度是O(m + n)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败97.25%。消耗内存：36.1MB，击败85.09%。
 */
public class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1 = m - 1, index2 = n - 1, index = nums1.length - 1;
    while (index1 >= 0 || index2 >= 0) {
      if (index1 < 0) {
        nums1[index--] = nums2[index2--];
      } else if (index2 < 0) {
        nums1[index--] = nums1[index1--];
      } else if (nums1[index1] >= nums2[index2]) {
        nums1[index--] = nums1[index1--];
      } else {
        nums1[index--] = nums2[index2--];
      }
    }
  }

}