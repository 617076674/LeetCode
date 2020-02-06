package question0386_lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是O(9 ^ (logn))。空间复杂度是O(logn)。
 *
 * 执行用时：5ms，击败54.72%。消耗内存：38.6MB，击败77.94%。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    private int num;

    public List<Integer> lexicalOrder(int n) {
        dfs(n);
        return result;
    }

    private void dfs(int n) {
        int i = 0;
        if (num == 0) {
            i++;
        }
        for (; i <= 9; i++) {
            num = num * 10 + i;
            if (num <= n) {
                result.add(num);
                dfs(n);
            }
            num /= 10;
        }
    }
}