package question0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。先求出全排列，再判断每个排列是否符合规则。
 *
 * 时间复杂度是O(n ^ n)。空间复杂度是O(n ^ 2)。
 *
 * 执行用时：94ms，击败5.03%。消耗内存：71.7MB，击败5.08%。
 */
public class Solution2 {
    private List<List<Integer>> listList = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private int[] nums;

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        permute(0);
        for (List<Integer> item : listList) {
            if (judge(item)) {
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (item.get(i) == j) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    tempList.add(sb.toString());
                }
                result.add(tempList);
            }
        }
        return result;
    }

    private void permute(int index) {
        if (index == nums.length) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            list.add(nums[index]);
            permute(index + 1);
            list.remove(list.size() - 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean judge(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.abs(i - j) == Math.abs(list.get(i) - list.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
