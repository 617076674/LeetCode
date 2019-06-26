package question105;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = create(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    private TreeNode create(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preLeft]);
        int k = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                k = i;
                break;
            }
        }
        int numLeft = k - inLeft;
        treeNode.left = create(preorder, inorder, preLeft + 1, preLeft + numLeft, inLeft, k - 1);
        treeNode.right = create(preorder, inorder, preLeft + numLeft + 1, preRight, k + 1, inRight);
        return treeNode;
    }
}
