package question0633_sum_of_square_numbers;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(c ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：30ms，击败5.19%。消耗内存：32.9MB，击败82.19%。
 */
public class Solution1 {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            if (isPerfectSquare(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPerfectSquare(int num) {
        return num == 0 || num % (Math.sqrt(num)) == 0;
    }
}
