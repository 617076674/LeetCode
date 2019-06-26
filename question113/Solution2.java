package question113;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> listList;
    List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        listList = new ArrayList<>();
        if (null == root) {
            return listList;
        }
        list = new ArrayList<>();
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
