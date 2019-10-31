package question0324_wiggle_sort_ii;

import java.util.Arrays;

/**
 * 先对nums数组进行排序，将其分成较小部分和较大部分两部分，其中较小部分的元素个数大于等于较大部分的元素个数。
 *
 * 假设两部分分别是[a1, a2, a3, ..., ak], [b1, b2, b3, ..., b(n - 1)]
 *
 * 那么将其翻转后交叉排列得到的数组必然是一个摆动排序：[ak, b(n - 1), a(k - 1), b(n - 2), ..., a1, b1]
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：4ms，击败97.34%。消耗内存：40.5MB，击败97.60%。
 */
public class Solution1 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, half = (n + 1) >> 1;
        int[] small = new int[half], big = new int[n - half];
        for (int i = 0; i < half; i++) {
            small[i] = nums[i];
        }
        for (int i = 0; i < n - half; i++) {
            big[i] = nums[i + half];
        }
        int index1 = half - 1, index2 = n - half - 1;
        for (int i = 0; i < n; i += 2) {
            nums[i] = small[index1--];
            if (i + 1 < n) {
                nums[i + 1] = big[index2--];
            }
        }
    }
}