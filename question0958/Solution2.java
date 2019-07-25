package question0958;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-25
 *
 * 设置一个停止标志，遇到空节点，停止标志为真，如果停止标志为真，再遍历遇到非空节点，则非完全二叉树。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：35.5MB，击败84.06%。
 */
public class Solution2 {
    public boolean isCompleteTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;   //停止标志位flag
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (null == treeNode) {
                if (!flag) {
                    flag = true;
                }
                continue;
            }
            if (flag) {
                return false;
            }
            queue.add(treeNode.left);
            queue.add(treeNode.right);
        }
        return true;
    }
}
