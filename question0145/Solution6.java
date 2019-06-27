package question0145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Morris后序遍历算法。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败12.22%。消耗内存35.8MB，击败35.83%。
 */
public class Solution6 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //与Morris前序遍历和Morris中序遍历不同，Morris后序遍历需要设置虚拟根节点
        TreeNode dummyRoot = new TreeNode(-1);
        //令原根节点为虚拟根节点的左孩子
        dummyRoot.left = root;
        TreeNode cur = dummyRoot;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    reverseOrder(cur.left, list);
                    cur = cur.right;
                }
            }
        }
        return list;
    }

    private void reverseOrder(TreeNode treeNode, List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        while (treeNode != null) {
            stack.add(treeNode.val);
            treeNode = treeNode.right;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }
}

