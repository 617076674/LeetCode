package question0507_perfect_number;

/**
 * 时间复杂度是O(num ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败72.02%。消耗内存：33.4MB，击败76.85%。
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i != num) {
                    sum += i;
                }
                int tmp = num / i;
                if (tmp != num) {
                    sum += tmp;
                }
            }
            if (sum > num) {
                return false;
            }
        }
        return sum == num;
    }
}
