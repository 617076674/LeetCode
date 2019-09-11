package question0022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 递归实现（用记忆化搜索来优化）。
 *
 * 时间复杂度和空间复杂度的计算比较复杂，略。
 *
 * 执行用时：3ms，击败87.02%。消耗内存：37.4MB，击败86.88。
 */
public class Solution3 {
    private Map<Integer, List<String>> dp = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("");
        }
        for (int i = 0; i < n; i++) {
            List<String> list1 = generateParenthesis(i);
            List<String> list2 = generateParenthesis(n - i - 1);
            for (String s1 : list1) {
                for (String s2 : list2) {
                    //写成这样也是可以的：list.add(s1 + "(" + s2 + ")");
                    list.add("(" + s1 + ")" + s2);
                }
            }
        }
        dp.put(n, list);
        return list;
    }
}
