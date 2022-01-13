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
        int begin = 1, gap = 1, end = n, step = 0, count = n;
        while (count > 1) {
            if (step % 2 == 0 || count % 2 != 0) {
                begin += gap;
            }
            if (step % 2 != 0 || count % 2 != 0) {
                end -= gap;
            }
            gap *= 2;
            count = (end - begin) / gap + 1;
            step++;
        }
        return begin;
    }
}