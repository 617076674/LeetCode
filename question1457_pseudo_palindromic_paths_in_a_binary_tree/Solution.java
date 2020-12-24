package question1457_pseudo_palindromic_paths_in_a_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int result;

    private List<Integer> list = new ArrayList<>();

    public int pseudoPalindromicPaths (TreeNode root) {
        if (null == root) {
            return result;
        }
        dfs(root);
        return result;
    }

    private void dfs(TreeNode treeNode) {
        if (null == treeNode.left && treeNode.right == null) {
            list.add(treeNode.val);
            if (isPreudoPalindromicPath(list)) {
                result++;
            }
            list.remove(list.size() - 1);
            return;
        }
        list.add(treeNode.val);
        if (null != treeNode.left) {
            dfs(treeNode.left);
        }
        if (null != treeNode.right) {
            dfs(treeNode.right);
        }
        list.remove(list.size() - 1);
    }

    private boolean isPreudoPalindromicPath(List<Integer> list) {
        int[] count = new int[10];
        for (int num : list) {
            count[num]++;
        }
        int odd = 0;
        for (int i = 1; i <= 9; i++) {
            if ((count[i] & 1) == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }

}