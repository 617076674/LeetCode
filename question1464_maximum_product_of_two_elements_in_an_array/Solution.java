package question1464_maximum_product_of_two_elements_in_an_array;

/**
 * 时间复杂度是 O(n)，其中 n 为数组 nums 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败88.99%。消耗内存：39.2MB，击败100.00%。
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num - 1 > max1) {
                max2 = max1;
                max1 = num - 1;
            } else if (num - 1 > max2) {
                max2 = num - 1;
            }
        }
        return max1 * max2;
    }
}