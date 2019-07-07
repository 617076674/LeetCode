package question0263;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 时间复杂度是O(log(num))。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败99.26%。消耗内存：33.7MB，击败12.44%。
 */
public class Solution {
    public boolean isUgly(int num) {
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
