package question0496;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-08-10
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(n1 * n2)，其中n1是nums1数组的长度，n2是nums2数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：39ms，击败5.80%。消耗内存：38.5MB，击败38.51%。
 */
public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] result = new int[n1];
        Arrays.fill(result, -1);
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    while (j + 1 < n2) {
                        j++;
                        if (nums2[j] > nums1[i]) {
                            result[i] = nums2[j];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
