package lcci1001_sorted_merge;

/**
 * 时间复杂度是O(m + n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.6MB，击败100.00%。
 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1, indexB = n - 1, index = m + n - 1;
        while (index >= 0) {
            if (indexA < 0) {
                A[index--] = B[indexB--];
            } else if (indexB < 0) {
                A[index--] = A[indexA--];
            } else if (A[indexA] >= B[indexB]) {
                A[index--] = A[indexA--];
            } else {
                A[index--] = B[indexB--];
            }
        }
    }
}