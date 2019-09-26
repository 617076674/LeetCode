package question0633_sum_of_square_numbers;

/**
 * 双指针。
 *
 * 时间复杂度是O(c ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.90%。消耗内存：33.2MB，击败81.88%。
 */
public class Solution2 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int num = left * left + right * right;
            if (num == c) {
                return true;
            }
            if (num < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
