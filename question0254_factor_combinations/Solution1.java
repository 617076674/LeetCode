package question0254_factor_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 执行用时：147ms，击败40.44%。消耗内存：35MB，击败100.00%。
 */
public class Solution1 {
    private List<List<Integer>> listList = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        getFactors(n, 2);
        return listList;
    }

    private void getFactors(int n, int limit) {
        if (list.size() != 0 && n >= list.get(list.size() - 1)) {
            list.add(n);
            listList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        for (int i = limit; i <= n; i++) {
            if (n % i == 0) {
                if (n / i == 1) {
                    continue;
                }
                list.add(i);
                getFactors(n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}