package question1385_find_the_distance_value_between_two_arrays;

/**
 * 暴力破解法。
 *
 * 时间复杂度为O(n1 * n2)，其中n1为数组arr1的长度，n2为数组arr2的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败86.24%。消耗内存：40.8MB，击败100.00%。
 */
public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    result++;
                    break;
                }
            }
        }
        return arr1.length - result;
    }
}