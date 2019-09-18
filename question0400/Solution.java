package question0400;

/**
 * 找规律。注意大整数越界。
 *
 * 执行用时：1ms，击败94.40%。消耗内存：33.8MB，击败78.62%。
 */
public class Solution {
    public int findNthDigit(int n) {
        int m = 1;
        while (true) {
            long numbers = countOfIntegers(m);
            if (n < numbers * m) {
                return digitAtIndex(n, m);
            }
            n -= numbers * m;
            m++;
        }
    }

    /**
     * m位的数字共有多少个
     */
    private long countOfIntegers(int m) {
        if (m == 1) {
            return 10;
        }
        return 9 * (long) Math.pow(10, m - 1);
    }

    /**
     * m位数的第一个数字
     */
    private long beginNumber(int m) {
        if (m == 1) {
            return 0;
        }
        return (long) Math.pow(10, m - 1);
    }

    /**
     * m位数中索引为index处的那个字符
     */
    private int digitAtIndex(int index, int m) {
        //确定m位数中索引index处的那个字符所属的数字
        long number = beginNumber(m) + index / m;
        for (int i = 1; i < m - index % m; i++) {
            number /= 10;
        }
        return (int) (number % 10);
    }
}
