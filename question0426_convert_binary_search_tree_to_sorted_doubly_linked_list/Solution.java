package question0426_convert_binary_search_tree_to_sorted_doubly_linked_list;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.3MB，击败7.63%。
 */
public class Solution {
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        Node node = treeToDoublyListHelper(root), cur = node;
        while (null != cur.right) {
            cur = cur.right;
        }
        node.left = cur;    //首节点的left指针指向尾节点
        cur.right = node;   //尾节点的right指针指向首节点
        return node;
    }

    //该函数用于将二叉搜索树转化为双向链表，不同于题目规定的双向链表，该双向链表的首节点的left指针为null，尾节点的right指针为null
    private Node treeToDoublyListHelper(Node root) {
        if (null == root) {
            return null;
        }
        Node leftResult = treeToDoublyListHelper(root.left), rightResult = treeToDoublyListHelper(root.right);
        if (null == leftResult) {
            if (rightResult != null) {
                rightResult.left = root;    //右子树转化成的双向链表的首节点的left指针指向root节点
                root.right = rightResult;   //root节点的right指针指向右子树转化成的双向链表的首节点
            }
            return root;
        }
        Node cur = leftResult;
        while (null != cur.right) {
            cur = cur.right;
        }
        cur.right = root;   //左子树转化成的双向链表的尾节点的right指针指向root节点
        root.left = cur;    //root节点的left指针指向左子树转化成的双向链表的尾节点
        if (null != rightResult){
            rightResult.left = root;    //右子树转化成的双向链表的首节点的left指针指向root节点
            root.right = rightResult;   //root节点的right指针指向右子树转化成的双向链表的首节点
        }
        return leftResult;
    }
}