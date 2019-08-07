package question0040;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 和question0040同样的思路，回溯。
 *
 * 执行用时174ms，击败5.02%。消耗内存：44.5MB，击败30.58%。
 */
public class Solution {
    private Set<List<Integer>> set = new HashSet<>();

    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        combinationSum2(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(set);
    }

    private void combinationSum2(int[] candidates, int target, List<Integer> list, int sum) {
        if (sum >= target) {
            if (sum == target) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (!used[i]) {
                if (list.size() == 0 || candidates[i] >= list.get(list.size() - 1)) {
                    list.add(candidates[i]);
                    used[i] = true;
                    combinationSum2(candidates, target, list, sum + candidates[i]);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
