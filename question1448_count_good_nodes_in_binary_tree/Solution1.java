package question1448_count_good_nodes_in_binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：44ms，击败5.32%。消耗内存：47.5MB，击败33.19%。
 */
public class Solution1 {

    private List<TreeNode> preOrder = new ArrayList<>();

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public int goodNodes(TreeNode root) {
        preOrderTraversal(root, null);
        int result = 0;
        for (TreeNode treeNode : preOrder) {
            if (isGoodNode(treeNode)) {
                result++;
            }
        }
        return result;
    }

    private boolean isGoodNode(TreeNode treeNode) {
        TreeNode cur = treeNode;
        while (true) {
            TreeNode parent = parentMap.get(cur);
            if (null == parent) {
                return true;
            }
            if (parent.val > treeNode.val) {
                return false;
            }
            cur = parent;
        }
    }

    private void preOrderTraversal(TreeNode treeNode, TreeNode parent) {
        if (null == treeNode) {
            return;
        }
        parentMap.put(treeNode, parent);
        preOrder.add(treeNode);
        preOrderTraversal(treeNode.left, treeNode);
        preOrderTraversal(treeNode.right, treeNode);
    }

}