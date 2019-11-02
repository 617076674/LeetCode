package question0510_inorder_successor_in_bst_ii;

/**
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败84.21%。消耗内存：95.9MB，击败100.00%。
 */
public class Solution {
    public Node inorderSuccessor(Node x) {
        if (null != x.right) {  //如果x的右孩子不为null，那么x后继节点就是右子树中的最小值
            Node cur = x.right;
            while (cur.left != null) {
                cur = cur.left; //一直往左走就行
            }
            return cur;
        }
        //如果x的右孩子为null，那么x的后继节点就需要从其父亲节点中寻找
        Node cur = x, parent = x.parent;
        while (parent != null && parent.right == cur) {
            cur = parent;
            parent = cur.parent;
        }
        return parent;
    }
}