package question0390_elimination_game;

/**
 * 无论是从左到右消，还是从右到左消，每次都会减少一半元素。
 *
 * 当从左到右消时，第一个元素肯定会被消掉。
 *
 * 当从右到左消时，只有当剩余个数是奇数时，第一个元素才会被消掉。
 *
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败99.39%。消耗内存：34.6MB，击败11.97%。
 */
public class Solution {
    public int lastRemaining(int n) {
        int result = 1, remain = n, step = 1, flag = 1;
        while (remain > 1) {
            if (flag == 1 || (remain & 1) == 1) {
                result += step;
            }
            flag *= -1;
            step <<= 1;
            remain >>= 1;
        }
        return result;
    }
}