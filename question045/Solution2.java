package question045;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82751536
 */
public class Solution2 {

    //dynamic programming
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[][] steps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                steps[i][j] = n - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            steps[i][i] = 0;
        }
        for (int i = 0; i >= 1 - n; i--) {
            for (int j = 0; j < n + i; j++) {
                if (nums[j] + j >= j - i) {
                    steps[j][j - i] = 1;
                } else {
                    for (int k = 1; k <= nums[j]; k++) {
                        steps[j][j - i] = Math.min(steps[j][j - i], 1 + steps[j + k][j - i]);
                    }
                }
            }
        }
        return steps[0][n - 1];
    }
}
