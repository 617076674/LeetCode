package question0431_encode_n_ary_tree_to_binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/encode-n-ary-tree-to-binary-tree/solution/java-di-gui-by-zxy0917-15/
 *
 * 从根节点开始，子节点的第一个节点放到二叉树的左节点，第二个子节点放在二叉树左子节点的的右节点，第三个子节点放在第二个子节点的右节点，
 * 即除了第一个子节点外同一层的其它节点都挂在第一个节点的右子树上，这样就能保证构成的二叉树根节点没有右子树，
 * 左子树的根节点+其右子树为同一层的子节点。
 *
 * 执行用时：2ms，击败84.62%。消耗内存：53.8MB，击败100.00%。
 */
public class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (null == root) {
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val);
        List<Node> children = root.children;
        //第一个子节点存在
        TreeNode cur = null;
        if (!children.isEmpty()) {
            treeNode.left = encode(children.get(0));
            cur = treeNode.left;
        }
        //如果还存在第二个子节点，把子节点挂在第一个子节点的右子树
        for (int i = 1; i < children.size(); i++) {
            cur.right = encode(children.get(i));
            cur = cur.right;
        }
        return treeNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (null == root) {
            return null;
        }
        Node node = new Node(root.val, new ArrayList<>());
        TreeNode cur = root.left;
        while (null != cur) {
            node.children.add(decode(cur));
            cur = cur.right;
        }
        return node;
    }
}