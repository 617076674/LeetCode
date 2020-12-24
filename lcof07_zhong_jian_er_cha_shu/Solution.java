package lcof07_zhong_jian_er_cha_shu;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[preLeft]);
        int k = inLeft;
        while (k <= inRight) {
            if (inOrder[k] == preOrder[preLeft]) {
                break;
            }
            k++;
        }
        treeNode.left = buildTree(preOrder, preLeft + 1, k - inLeft + preLeft, inOrder, inLeft, k - 1);
        treeNode.right = buildTree(preOrder, k - inLeft + preLeft + 1, preRight, inOrder, k + 1, inRight);
        return treeNode;
    }

}