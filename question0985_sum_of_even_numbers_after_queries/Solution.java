package question0985_sum_of_even_numbers_after_queries;

/**
 * 时间复杂度是O(n + m)，其中n是数组A的长度，m是数组queries的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败100.00%。消耗内存：59MB，击败88.00%。
 */
public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sumOfEven = 0;
        for (int num : A) {
            if ((num & 1) == 0) {
                sumOfEven += num;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], index = queries[i][1];
            if ((A[index] & 1) == 0) {
                if ((val & 1) == 0) {
                    sumOfEven += val;
                } else {
                    sumOfEven -= A[index];
                }
            } else {
                if ((val & 1) == 1) {
                    sumOfEven += A[index] + val;
                }
            }
            A[index] += val;
            result[i] = sumOfEven;
        }
        return result;
    }
}
