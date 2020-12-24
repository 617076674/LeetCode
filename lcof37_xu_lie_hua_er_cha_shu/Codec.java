package lcof37_xu_lie_hua_er_cha_shu;

import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
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
        String[] strings = data.split(",");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : strings) {
            stack.add(s);
        }
        return deserialize(stack);
    }

    private TreeNode deserialize(LinkedList<String> stack) {
        String s = stack.pop();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.left = deserialize(stack);
        treeNode.right = deserialize(stack);
        return treeNode;
    }

}