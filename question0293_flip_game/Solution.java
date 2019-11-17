package question0293_flip_game;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flip-game/
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败80.17%。消耗内存：36.1MB，击败100.00%。
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                result.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return result;
    }
}