package question889;

/**
 * @author qianyihui
 * @date 2019-06-10
 *
 * 首先，我们需要理解，为什么根据前序遍历和后序遍历得到的二叉树不唯一。
 *
 *      1         1
 *    ↙     和     ↘
 *   2               2
 *
 * 考虑上述两棵二叉树
 *
 *              左边的树        右边的树
 * 前序遍历：    [1, 2]         [2, 1]
 * 后序遍历：    [1, 2]         [2, 1]
 *
 * 这个例子解释了为什么根据前序遍历和后序遍历得到的二叉树是不唯一的。
 *
 * 在这个实现中，如果输入上述前序遍历[1, 2]及后序遍历[2, 1]，得到的树会是左边的那颗树。
 *
 * 因为在递归地过程中，先确定其左子树再确定其右子树。当只剩下一个节点未确定时，该节点会被确定到左子树上，右子树为null。
 *
 * 时间复杂度是O(n ^ 2)，其中n为二叉树中的节点个数。空间复杂度是O(n)。
 *
 * 执行时间：4ms，击败79.86%。消耗内存：36.8MB，击败90.32%。
 */
public class Solution {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructFromPrePost(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(pre[preLeft]);
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        //在后序遍历中寻找到值等于pre[preLeft + 1]的那个位置
        int i = postLeft;
        for (; i <= postRight; i++) {
            if (post[i] == pre[preLeft + 1]) {
                break;
            }
        }
        root.left = constructFromPrePost(pre, preLeft + 1, i - postLeft + preLeft + 1, post, postLeft, i);
        root.right = constructFromPrePost(pre, i - postLeft + preLeft + 2, preRight, post, i + 1, postRight - 1);
        return root;
    }

}
