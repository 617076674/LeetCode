package question0145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 新增一个指针pre，执行前一个访问的节点。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：2ms，击败61.06%。消耗内存：34.9MB，击败37.05%。
 */
public class Solution5 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                //当前节点没有右孩子时，因为已经是第二次访问该节点，因此可以记录该值
                //或者pre节点就是当前节点的右孩子时，说明已经是第三次访问该节点，可以记录该值
                if (cur.right == null || pre == cur.right) {
                    list.add(cur.val);
                    //显然，前一个访问的节点需要更新为当前节点
                    pre = cur;
                    //以当前节点为根节点的子树已经遍历结束
                    cur = null;
                //第二次访问当前节点，将当前节点入栈，并访问其右孩子
                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}

