package question0113_path_sum_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：39.5MB，击败19.50%。
 */
public class Solution2 {

    private List<List<Integer>> listList = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return listList;
        }
        dfs(root, sum);
        return listList;
    }

    private void dfs(TreeNode root, int sum) {
        list.add(root.val);
        if (null == root.left && null == root.right) {
            sum -= root.val;
            if (sum == 0) {
                listList.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        if (null != root.left) {
            dfs(root.left, sum - root.val);
        }
        if (null != root.right) {
            dfs(root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }

}