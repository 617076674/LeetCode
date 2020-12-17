package question0922_sort_array_by_parity_ii;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n是数组A的长度。空间复杂度是O(1)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：39.8MB，击败96.75%。
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            while ((A[i] & 1) == 1) {
                swap(A, i, j);
                j += 2;
            }
        }
        return A;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
