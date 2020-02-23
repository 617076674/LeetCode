package question5171_closest_divisors;

/**
 * 如果是num + 1或num + 2是一个完全平方数，那结果中的两个数均是num + 1或num + 2的平方根。
 *
 * 如果num + 1或num + 2不是一个完全平方数，要使结果中的两个数相差最小，那就是从num + 1或num + 2的平方跟开始遍历得到的第一对数。
 *
 * 时间复杂度是O(num ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败100.00%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution {
    public int[] closestDivisors(int num) {
        int num1 = -1, num2 = -1;
        for (int i = (int) Math.sqrt(num + 2); i >= 0; i--) {
            if ((num + 2) % i == 0) {
                num1 = i;
                num2 = (num + 2) / i;
                break;
            }
        }
        for (int i = (int) Math.sqrt(num + 1); i >= 0; i--) {
            if ((num + 1) % i == 0) {
                if (num1 == -1 || Math.abs(i - (num + 1) / i) < Math.abs(num1 - num2)) {
                    num1 = i;
                    num2 = (num + 1) / i;
                }
                break;
            }
        }
        return new int[] {num1, num2};
    }
}