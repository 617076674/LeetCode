package question0357;

/**
 * @author qianyihui
 * @date 2019-08-20
 *
 * 当n == 0时，[0, 1)范围内满足条件的就一个数：0。
 *
 * 当n == 1时，[0, 10)范围内满足条件的有十个数：0、1、2、3、4、5、6、7、8、9。
 *
 * 当n > 10时，[10000000000, 10 ^ n)范围内已经不会有满足条件的数了，其和[0, 10000000000)范围内满足条件的数相同。
 *
 * 当n∈[2, 10]时，第一个数可以从[1, 9]中选，有9种选择，第二个数可以从[0, 9]中选，但不能和第一个数相同，也有9种选择，而后续的数选择数将减少。
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：1ms，击败9.33%。消耗内存：33.7MB，击败14.28%。
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        int tmp = 9;
        for (int i = 11 - n; i <= 9; i++) {
            tmp *= i;
        }
        return countNumbersWithUniqueDigits(n - 1) + tmp;
    }
}
