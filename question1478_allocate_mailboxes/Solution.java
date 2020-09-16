package question1478_allocate_mailboxes;

import java.util.Arrays;

/**
 * 动态规划 + 数学
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为 houses 数组的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：8ms，击败96.86%。消耗内存：39.7MB，击败20.34%。
 */
public class Solution {

    private int n;

    private int[][] memoForKMaiBox;

    private int[][] memoForOneMailBox;

    public int minDistance(int[] houses, int k) {
        n = houses.length;
        Arrays.sort(houses);
        memoForKMaiBox = new int[n][k + 1];
        memoForOneMailBox = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memoForKMaiBox[i], -1);
            Arrays.fill(memoForOneMailBox[i], -1);
        }
        return minDistance(houses, n - 1, k);
    }

    /**
     * 为 [0, index] 范围内的房子分配 k 个邮筒
     */
    private int minDistance(int[] houses, int index, int k) {
        if (k >= index + 1) {
            return 0;
        }
        if (k == 1) {
            return minDistanceForOneMailBox(houses, 0, index);
        }
        if (memoForKMaiBox[index][k] != -1) {
            return memoForKMaiBox[index][k];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            result = Math.min(result, minDistanceForOneMailBox(houses, i + 1, index) + minDistance(houses, i, k - 1));
        }
        memoForKMaiBox[index][k] = result;
        return result;
    }

    /**
     * 为 [left, right] 范围内的房子分配 1 个邮筒的最小距离
     */
    private int minDistanceForOneMailBox(int[] houses, int left, int right) {
        if (-1 != memoForOneMailBox[left][right]) {
            return memoForOneMailBox[left][right];
        }
        int mid = left + ((right - left) >> 1);
        int mailBox;
        if (((right - left + 1) & 1) == 1) {
            mailBox = houses[mid];
        } else {
            mailBox = (houses[mid] + houses[mid + 1]) / 2;
        }
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += Math.abs(houses[i] - mailBox);
        }
        memoForOneMailBox[left][right] = result;
        return result;
    }

}