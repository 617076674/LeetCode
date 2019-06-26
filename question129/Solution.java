package question129;

import java.util.ArrayList;

public class Solution {
    private ArrayList<TreeNode> tempPath = new ArrayList<>();
    private ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (null == root) {
            return sum;
        }
        dfs(root);
        for (ArrayList<TreeNode> list : paths) {
            int len = 0;
            for (TreeNode node : list) {
                len = len * 10 + node.val;
            }
            sum += len;
        }
        return sum;
    }

    private void dfs(TreeNode nowVisit) {
        tempPath.add(nowVisit);
        if (null == nowVisit.left && null == nowVisit.right) {
            paths.add(new ArrayList<>(tempPath));
            tempPath.remove(tempPath.size() - 1);
            return;
        }
        if (null != nowVisit.left) {
            dfs(nowVisit.left);
        }
        if (null != nowVisit.right) {
            dfs(nowVisit.right);
        }
        tempPath.remove(tempPath.size() - 1);
    }
}
