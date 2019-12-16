package question0294_flip_game_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：12ms，击败92.97%。消耗内存：41.4MB，击败100.00%。
 */
public class Solution {
    private Map<String, Boolean> dp = new HashMap<>();

    public boolean canWin(String s) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String tmp = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                if (!canWin(tmp)) {
                    dp.put(tmp, false);
                    return true;
                }
                dp.put(tmp, true);
            }
        }
        return false;
    }
}