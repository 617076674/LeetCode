package question0277_find_the_celebrity;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败76.30%。消耗内存：44.7MB，击败100.00%。
 */
public class Solution1 extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isCelebrity(int index, int n) {
        for (int i = 0; i < n; i++) {
            if (i == index) {
                continue;
            }
            if (knows(index, i) || !knows(i, index)) {
                return false;
            }
        }
        return true;
    }
}