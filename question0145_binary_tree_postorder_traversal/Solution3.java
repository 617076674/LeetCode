package question0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历的本质是：在第三次访问到该节点的时候记录该节点的值。
 *
 * 入栈是第一次访问该节点。出栈是第二次访问该节点。因此还需要一个标记位visited来标记是否是第三次访问该节点。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：3ms，击败12.22%。消耗内存：35.3MB，击败36.96%。
 */
public class Solution3 {
    private class TagNode {
        TreeNode treeNode;

        boolean visited;

        TagNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TagNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(new TagNode(cur));
                cur = cur.left;
            } else {
                TagNode tagNode = stack.pop();
                cur = tagNode.treeNode;
                //如果是第三次访问该节点
                if (tagNode.visited) {
                    list.add(tagNode.treeNode.val);
                    //第三次访问完该节点后，以该节点为根的树也就访问完毕了
                    cur = null;
                //如果是第二次访问该节点，需要将该节点visited标记位true并将该节点入栈
                } else {
                    tagNode.visited = true;
                    stack.push(tagNode);
                    //第二次访问该节点后显然是访问右孩子
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}