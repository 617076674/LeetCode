package question0216_combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯。
 *
 * 执行用时：1ms，击败69.81%。消耗内存：37.3MB，击败17.32%。
 */
public class Solution {

    private List<List<Integer>> retListList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        generateCombination(new ArrayList<>(), 0, k, n);
        return retListList;
    }

    private void generateCombination(List<Integer> list, int sum, int k, int n) {
        if (list.size() == k && sum == n) {
            retListList.add(new ArrayList<>(list));
            return;
        }
        if (list.size() > k || sum > n) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (list.isEmpty() || i > list.get(list.size() - 1)) {
                list.add(i);
                generateCombination(list, sum + i, k, n);
                list.remove(list.size() - 1);
            }
        }
    }

}