package question0103;

import java.util.*;

/**
 * 借鉴层序遍历的思路，对一些层进行反转即可。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是二叉树中的节点个数。
 *
 * 执行用时：3ms，击败61.52%。消耗内存：36.3MB，击败40.11%。
 */
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if ((index & 1) == 1) {
                Collections.reverse(list);
            }
            listList.add(list);
            index++;
        }
        return listList;
    }
}
