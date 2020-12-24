package lcof36_er_cha_sou_suo_shu_yu_shuang_xiang_lian_biao;

public class Solution1 {

    private Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        inOrderTraversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrderTraversal(Node node) {
        if (null == node) {
            return;
        }
        inOrderTraversal(node.left);
        if (pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        node.left = pre;
        pre = node;
        inOrderTraversal(node.right);
    }

}