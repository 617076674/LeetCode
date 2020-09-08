package question0077_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。每次往组合中添加的值都比组合中最后一个值要小，这样可以确保不重复。
 *
 * 时间复杂度是O(n ^ k)。空间复杂度是O(k)。
 *
 * 执行用时：77ms，击败34.76%。消耗内存：52.5MB，击败26.67%。
 */
public class Solution1 {

    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(new ArrayList<>(), n, k);
        return listList;
    }

    private void combine(List<Integer> list, int n, int k) {
        if (list.size() == k) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.isEmpty() && list.get(list.size() - 1) <= i) {
                continue;
            }
            list.add(i);
            combine(list, n, k);
            list.remove(list.size() - 1);
        }
    }

}