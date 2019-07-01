package question0297;

import java.util.LinkedList;
import java.util.List;

/**
 * 根据前序遍历来重建二叉树。对于NULL节点，用$符号来补。
 *
 * serialize()和deserialize()的时间复杂度均是O(n)，其中n为树中的节点个数。
 * serialize()和deserialize()的空间复杂度均是O(h)，其中h为树的高度。
 *
 * 执行用时：31ms，击败67.64%。消耗内存：46.8MB，击败61.20%。
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    private void preOrderTraversal(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append("$,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preOrderTraversal(root.left, sb);
        preOrderTraversal(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preOrder = data.split(",");
        List<String> list = new LinkedList<>();
        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[i].length() > 0) {
                list.add(preOrder[i]);
            }
        }
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        String string = list.get(0);
        list.remove(0);
        if (!string.equals("$")) {
            TreeNode treeNode = new TreeNode(Integer.valueOf(string));
            treeNode.left = deserialize(list);
            treeNode.right = deserialize(list);
            return treeNode;
        } else {
            return null;
        }
    }
}