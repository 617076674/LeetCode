package question1534_count_good_triplets;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为数组 arr 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：20ms，击败100.00%。消耗内存：37.7MB，击败100.00%。
 */
public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[k] - arr[j]) <= b
                        && Math.abs(arr[i] - arr[k]) <= c) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}