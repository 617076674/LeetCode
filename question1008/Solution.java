package question1008;

/**
 * @author qianyihui
 * @date 2019-07-22
 *
 * 执行用时：2ms，击败91.64%。消耗内存：35.2MB，击败59.71%。
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[left]);
        int index = left;
        while (index + 1 <= right && preorder[index + 1] < preorder[left]) {
            index++;
        }
        treeNode.left = bstFromPreorder(preorder, left + 1, index);
        treeNode.right = bstFromPreorder(preorder, index + 1, right);
        return treeNode;
    }
}
