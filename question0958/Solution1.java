package question0958;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-25
 *
 * 先层序遍历将节点放入一个list里，再遍历该list来判断是否是一颗完全二叉树。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：5ms，击败6.79%。消耗内存：36.3MB，击败84.06%。
 */
public class Solution1 {
    public boolean isCompleteTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        List<TreeNode> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            levelOrder.add(treeNode);
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
        for (int i = 0; i < levelOrder.size(); i++) {
            if (2 * i + 1 < levelOrder.size() && levelOrder.get(i).left != levelOrder.get(2 * i + 1)) {
                return false;
            }
            if (2 * i + 2 < levelOrder.size() && levelOrder.get(i).right != levelOrder.get(2 * i + 2)) {
                return false;
            }
        }
        return true;
    }
}
