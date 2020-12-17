package question1643_kth_smallest_instructions;

/**
 * 排列组合。
 *
 * 时间复杂度和空间复杂度均是 O(destination[0] * destination[1])。
 *
 * 执行用时：3ms，击败45.48%。消耗内存：38MB，击败56.50%。
 */
public class Solution {

    private StringBuilder sb = new StringBuilder();

    private int[][] memo;

    public String kthSmallestPath(int[] destination, int k) {
        int len = (Math.max(destination[0], destination[1]) << 1) + 1;
        memo = new int[len][len];
        kthSmallestPath(destination[0], destination[1], k);
        return sb.toString();
    }

    private void kthSmallestPath(int v, int h, int k) {
        if (k == 1) {
            for (int i = 0; i < h; i++) {
                sb.append("H");
            }
            for (int i = 0; i < v; i++) {
                sb.append("V");
            }
            return;
        }
        int count = combination(v + h - 1, h - 1);
        if (k <= count) {
            sb.append("H");
            kthSmallestPath(v, h - 1, k);
        } else {
            sb.append("V");
            kthSmallestPath(v - 1, h, (k - count));
        }
    }

    private int combination(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        if (memo[n][k] != 0) {
            return memo[n][k];
        }
        memo[n][k] = combination(n - 1, k) + combination(n - 1, k - 1);
        return memo[n][k];
    }

}