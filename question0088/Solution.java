package question0088;

/**
 * 归并排序的应用。
 *
 * 时间复杂度是O(m + n)。空间复杂度是O(m)。
 *
 * 执行用时：1ms，击败97.25%。消耗内存：36.1MB，击败85.09%。
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (index1 >= m) {
                nums1[i] = nums2[index2++];
            } else if (index2 >= n) {
                nums1[i] = temp[index1++];
            } else if (temp[index1] > nums2[index2]) {
                nums1[i] = nums2[index2++];
            } else {
                nums1[i] = temp[index1++];
            }
        }
    }
}
