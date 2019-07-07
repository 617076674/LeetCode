package question0264;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(nlogn)。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超出时间限制。
 */
public class Solution1 {
    public int nthUglyNumber(int n) {
        int index = 0;
        for (int i = 1; ; i++) {
            if (isUgly(i)) {
                if (++index == n) {
                    return i;
                }
            }
        }
    }

    private boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
