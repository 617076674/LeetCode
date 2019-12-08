package question0254_factor_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：33.7MB，击败100.00%。
 */
public class Solution2 {
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }

    private List<List<Integer>> getFactors(int n, int limit) {
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = limit; i * i <= n; i++) {
            if (n % i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(n / i);
                listList.add(list);
                for (List<Integer> tmp : getFactors(n / i, i)) {
                    tmp.add(i);
                    listList.add(tmp);
                }
            }
        }
        return listList;
    }
}