package question0865;

import java.util.*;

/**
 * @author qianyihui
 * @date 2019-07-28
 *
 * 层序遍历时用一个Map来记录每一个节点的父节点。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中节点个数。
 *
 * 执行用时：5ms，击败11.63%。消耗内存：36MB，击败52.94%。
 */
public class Solution1 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (null == root || (root.left == null && root.right == null)) {
            return root;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> deepestLeaves = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            deepestLeaves.clear();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                deepestLeaves.add(treeNode);
                if (null != treeNode.left) {
                    parentMap.put(treeNode.left, treeNode);
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    parentMap.put(treeNode.right, treeNode);
                    queue.add(treeNode.right);
                }
            }
        }
        Set<TreeNode> parentSet = new HashSet<>();
        while (deepestLeaves.size() != 1) {
            parentSet.clear();
            for (TreeNode treeNode : deepestLeaves) {
                parentSet.add(parentMap.get(treeNode));
            }
            deepestLeaves.clear();
            deepestLeaves.addAll(parentSet);
        }
        return deepestLeaves.get(0);
    }
}
