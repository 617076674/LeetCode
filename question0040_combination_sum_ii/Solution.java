package question0040_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 回溯。
 *
 * 执行用时6ms，击败77.19%。消耗内存：37.4MB，击败89.90%。
 */
public class Solution {
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    //排序是关键
        combinationSum2(candidates, target, new ArrayList<>(), 0, 0);
        return listList;
    }

    private void combinationSum2(int[] candidates, int target, List<Integer> list, int sum, int begin) {
        if (sum >= target) {
            if (sum == target) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {  //跳过非首次出现的数，避免重复
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, target, list, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}