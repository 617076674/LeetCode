package question0526_beautiful_arrangement;

import java.util.concurrent.locks.LockSupport;

/**
 * 回溯法。
 *
 * 时间复杂度是O(N!)。空间复杂度是O(N)。
 *
 * 执行用时：80ms，击败41.70%。消耗内存：33.1MB，击败63.89%。
 */
public class Solution {

    private boolean[] used;

    private int result;

    public int countArrangement(int N) {
        used = new boolean[N];
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (index == used.length) {
            result++;
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && ((i + 1) % (index + 1) == 0 || (index + 1) % (i + 1) == 0)) {
                used[i] = true;
                dfs(index + 1);
                used[i] = false;
            }
        }
    }

}