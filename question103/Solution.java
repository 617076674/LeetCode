package question103;

import java.util.*;

public class Solution {

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
            if (index % 2 == 1) {
                Collections.reverse(list);
            }
            listList.add(list);
            index++;
        }
        return listList;
    }
}
