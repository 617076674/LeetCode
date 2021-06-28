package question0668_kth_smallest_number_in_multiplication_table;

public class Solution {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(m, n, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 在 m * n 的乘法表中寻找不大于 num 的数字个数
     */
    private static int check(int m, int n, int num) {
        int result = 0;
        for (int i = 1; i <= m; i++) {
            result += Math.min(n, num / i);
        }
        return result;
    }

}