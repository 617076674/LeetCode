package question1228_missing_number_in_arithmetic_progression;

/**
 * 时间复杂度是O(n)，其中n为数组arr的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.3MB，击败5.88%。
 */
public class Solution {
    public int missingNumber(int[] arr) {
        int gap = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > gap) {
                return (arr[i] + arr[i - 1]) >> 1;
            } else if (Math.abs(arr[i] - arr[i - 1]) < gap) {
                return (arr[1] + arr[0]) >> 1;
            }
        }
        return arr[0];  // 处理数组arr中所有数都相等的情况
    }
}