package question1028_recover_a_tree_from_preorder_traversal;

import java.util.Stack;

/**
 * 栈的应用。
 *
 * 先序遍历的访问节点顺序是：根 - 左子树 - 右子树。
 *
 * 假设在先序遍历中某个节点值 T 的前一个节点是 S，有以下两种情况：
 * （1）T 是 S 的左孩子。
 * （2）T 是从根节点到 S 的路径（不包括 S）上某个节点的右孩子。
 * 为什么这里不包括 S 呢？
 * 因为如果 T 是 S 的右孩子，那么先序遍历中 T 的前一个节点必然是 S 的左孩子，不会是 S。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 S 的长度。
 *
 * 执行用时：7ms，击败53.27%。消耗内存：40.4MB，击败25.00%。
 */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            int depth = 0;
            while (S.charAt(i) == '-') {
                depth++;
                i++;
            }
            int value = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                value = value * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            if (depth == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            } else {
                while (depth != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}