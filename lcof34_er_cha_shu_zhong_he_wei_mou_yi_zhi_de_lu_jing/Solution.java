package lcof34_er_cha_shu_zhong_he_wei_mou_yi_zhi_de_lu_jing;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> tmpPath = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return result;
        }
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode treeNode, int sum) {
        if (treeNode.left == null && treeNode.right == null) {
            if (sum == treeNode.val) {
                tmpPath.add(sum);
                result.add(new ArrayList<>(tmpPath));
                tmpPath.remove(tmpPath.size() - 1);
            }
            return;
        }
        tmpPath.add(treeNode.val);
        if (null != treeNode.left) {
            dfs(treeNode.left, sum - treeNode.val);
        }
        if (null != treeNode.right) {
            dfs(treeNode.right, sum - treeNode.val);
        }
        tmpPath.remove(tmpPath.size() - 1);
    }

}