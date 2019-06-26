package question106;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = create(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private TreeNode create(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[postRight]);
        int k = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == postorder[postRight]) {
                k = i;
                break;
            }
        }
        int numLeft = k - inLeft;
        treeNode.left = create(inorder, postorder, inLeft, k - 1, postLeft, postLeft + numLeft - 1);
        treeNode.right = create(inorder, postorder, k + 1, inRight, postLeft + numLeft, postRight - 1);
        return treeNode;
    }
}
