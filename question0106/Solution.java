package question0106;

/**
 * 递归实现。
 *
 * 以题给的例子做说明：
 *
 * preorder = [9, 15, 7, 20, 3]
 * inorder = [9, 3, 15, 20, 7]
 *
 * 我们能够根据后序遍历的最后一个点3，将中序遍历序列变成3部分，左子树部分[9]，右子树部分[15, 20, 7]，根节点是3。再继续递归的构建左右子树即可。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为所构建的二叉树的高度。
 *
 * 执行用时：32ms，击败44.95%。消耗内存：38.1MB，击败67.56%。
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = create(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private TreeNode create(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        //递归终止条件
        if (postLeft > postRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postRight]);
        int k = 0;
        //在中序遍历序列中找到后序遍历序列的第postRight个节点
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == postorder[postRight]) {
                k = i;
                break;
            }
        }
        int numLeft = k - inLeft;   //左子树的元素个数
        //递归构建左右子树
        treeNode.left = create(inorder, postorder, inLeft, k - 1, postLeft, postLeft + numLeft - 1);
        treeNode.right = create(inorder, postorder, k + 1, inRight, postLeft + numLeft, postRight - 1);
        return treeNode;
    }
}
