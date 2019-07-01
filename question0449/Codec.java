package question0449;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据二叉搜索树的前序遍历来重建二叉树。
 *
 * serialize()和deserialize()的时间复杂度均是O(n)，其中n为树中的节点个数。
 * serialize()的空间复杂度是O(1)。deserialize()的空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：28ms，击败48.58%。消耗内存：44.2MB，击败47.66%。
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preOrder = preOrderTraversal(root);
        StringBuilder sb = new StringBuilder();
        for (Integer item : preOrder) {
            sb.append(item);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preOrder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    preOrder.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preOrder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] preOrder = data.split(",");
        return createTree(preOrder, 0, preOrder.length - 1);
    }

    private TreeNode createTree(String[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(preOrder[left]));
        int index = left + 1;
        while (index <= right && Integer.valueOf(preOrder[index]) < root.val) {
            index++;
        }
        root.left = createTree(preOrder, left + 1, index - 1);
        root.right = createTree(preOrder, index, right);
        return root;
    }

}