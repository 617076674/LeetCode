package question0297_serialize_and_deserialize_binary_tree;

import java.util.Stack;

/**
 * 对于前序遍历序列 1,2,#,#,3,4,#,#,5,#,#，我们可以知道其根节点值为 1，但却不知道其左右子树的范围。
 *
 * 如果在考虑完左子树后将其删除，那么剩下的一定都是右子树。这个操作可以用栈来完成。
 *
 * serialize 和 deserialize 的时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：15ms，击败74.70%。消耗内存：42.3MB，击败21.43%。
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode now = stack.pop();
            if (null == now) {
                sb.append("#,");
            } else {
                sb.append(now.val).append(",");
                stack.push(now.right);
                stack.push(now.left);
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = nodes.length - 1; i >= 0; i--) {
            stack.push(nodes[i]);
        }
        return deserialize(stack);
    }

    private TreeNode deserialize(Stack<String> stack) {
        String first = stack.pop();
        if (first.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(stack);
        root.right = deserialize(stack);
        return root;
    }

}