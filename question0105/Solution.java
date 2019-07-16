package question0105;

/**
 * 递归实现。
 *
 * 以题给的例子做说明：
 *
 * preorder = [3, 9, 20, 15, 7]
 * inorder = [9, 3, 15, 20, 7]
 *
 * 我们能够根据前序遍历的第一个点3，将中序遍历序列变成3部分，左子树部分[9]，右子树部分[15, 20, 7]，根节点是3。再继续递归的构建左右子树即可。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为所构建的二叉树的高度。
 *
 * 执行用时：32ms，击败47.39%。消耗内存：37.6MB，击败66.82%。
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode create(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        //递归终止条件
        if (preLeft > preRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int k = 0;
        //在中序遍历序列中找到前序遍历序列的第preLeft个节点
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                k = i;
                break;
            }
        }
        int numLeft = k - inLeft;   //左子树的元素个数
        //递归构建左右子树
        treeNode.left = create(preorder, inorder, preLeft + 1, preLeft + numLeft, inLeft, k - 1);
        treeNode.right = create(preorder, inorder, preLeft + numLeft + 1, preRight, k + 1, inRight);
        return treeNode;
    }
}
