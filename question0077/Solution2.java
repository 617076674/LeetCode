package question0077;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。将原问题——在[1, n]里面求k个数的所有组合拆解成2个子问题：
 * （1）在[2, n]里面求k - 1个数的所有组合，即组合中包括1。
 * （2）在[2, n]里面求k个数的所有组合，即组合中不包括1。
 *
 * 时间复杂度是O(n ^ k)。空间复杂度是O(k)。
 *
 * 执行用时：5ms，击败97.72%。消耗内存：49MB，击败70.77%。
 */
public class Solution2 {

    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(new ArrayList<>(), 1, n, k);
        return listList;
    }

    private void combine(List<Integer> list, int begin, int end, int k) {
        if (k == 0) {
            listList.add(new ArrayList<>(list));
            return;
        }
        if (end - begin + 1 < k) {
            return;
        }
        list.add(begin);
        combine(list, begin + 1, end, k - 1);
        list.remove(list.size() - 1);
        combine(list, begin + 1, end, k);
    }

}
