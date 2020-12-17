package lcof37_xu_lie_hua_er_cha_shu;

import java.util.Stack;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // 1,2,#,#,3,4,#,#,5,#,#
        TreeNode cur = root;
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

    // Decodes your encoded data to tree.
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
        TreeNode treeNode = new TreeNode(Integer.parseInt(first));
        treeNode.left = deserialize(stack);
        treeNode.right = deserialize(stack);
        return treeNode;
    }

}