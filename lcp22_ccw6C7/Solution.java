package lcp22_ccw6C7;

public class Solution {

    public int paintingPlan(int n, int k) {
        if (k < n || k > n * n) {
            return 0;
        }
        return paintingPlan(n, k, 0, 0, 0, 0);
    }

    private int paintingPlan(int n, int k, int rowIndex, int colIndex, int rows, int cols) {
        if (k == 0) {
            return 1;
        }
        if (k < 0) {
            return 0;
        }
        if (rowIndex >= n || colIndex >= n) {
            return 0;
        }
        int result = 0;
        // 第 rowIndex 行涂黑
        result += paintingPlan(n, k - (n - cols), rowIndex + 1, colIndex, rows + 1, cols);
        // 第 rowIndex 行不涂黑
        result += paintingPlan(n, k, rowIndex + 1, colIndex, rows, cols);
        // 第 colIndex 行涂黑
        result += paintingPlan(n, k - (n - rows), colIndex + 1, rowIndex, rows, cols + 1);
        // 第 colIndex 行不涂黑
        result += paintingPlan(n, k, colIndex + 1, rowIndex, rows, cols);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().paintingPlan(2, 2));
    }
}