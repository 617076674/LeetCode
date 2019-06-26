package question0004;

/**
 * 找出前len个数。
 * <p>
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1是nums1数组的长度，n2是nums2数组的长度。
 * <p>
 * 执行用时：12ms，击败86.12%。消耗内存：52.8MB，击败69.61%。
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int len = ((n1 + n2) >> 1) + 1;
        int[] array = new int[len];
        int i = 0, j = 0, index = 0;
        while (index < array.length) {
            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    array[index] = nums1[i++];
                } else {
                    array[index] = nums2[j++];
                }
            } else if (i >= n1 && j < n2) {
                array[index] = nums2[j++];
            } else if (i < n1) {
                array[index] = nums1[i++];
            }
            index++;
        }
        if (((n1 + n2) & 1) == 0) {
            return 0.5 * (array[len - 1] + array[len - 2]);
        }
        return array[len - 1];
    }
}
