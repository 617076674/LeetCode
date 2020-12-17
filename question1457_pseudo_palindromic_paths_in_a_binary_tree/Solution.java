package question1457_pseudo_palindromic_paths_in_a_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int result;

    private List<Integer> list = new ArrayList<>();

    public int pseudoPalindromicPaths (TreeNode root) {
        return -1;
    }

    private void dfs(TreeNode treeNode) {
        if (null == treeNode) {
            if (isPreudoPalindromicPath(list)) {
                result++;
            }
            return;
        }
        list.add(treeNode.val);
        dfs(treeNode.left);
        dfs(treeNode.right);
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