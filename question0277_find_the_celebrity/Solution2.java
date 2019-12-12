package question0277_find_the_celebrity;

/**
 * 双指针。
 *
 * 时间复杂度是O(n ^ 2)。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败94.80%。消耗内存：44.9MB，击败100.00%。
 */
public class Solution2 extends Relation {
    public int findCelebrity(int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }
        //现在left == right，该索引就是候选的名人，判断该候选名人是否是真正的名人
        for (int i = 0; i < n; i++) {
            if (i == left) {
                continue;
            }
            if (knows(left, i) || !knows(i, left)) {
                return -1;
            }
        }
        return left;
    }
}