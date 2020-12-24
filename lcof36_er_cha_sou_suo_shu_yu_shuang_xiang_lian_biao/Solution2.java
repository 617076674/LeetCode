package lcof36_er_cha_sou_suo_shu_yu_shuang_xiang_lian_biao;

public class Solution2 {

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        Node leftChild = root.left, rightChild = root.right;
        root.left = root.right = null;
        Node leftResult = treeToDoublyList(leftChild), rightResult = treeToDoublyList(rightChild);
        Node head;
        if (null != leftResult) {
            Node cur = leftResult.left;
            cur.right = root;
            root.left = cur;
            head = leftResult;
        } else {
            head = root;
        }
        if (null != rightResult) {
            root.right = rightResult;
            rightResult.left.right = head;
            head.left = rightResult.left;
            rightResult.left = root;
        } else {
            root.right = head;
            head.left = root;
        }
        return head;
    }

}