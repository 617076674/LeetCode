package question101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<TreeNode> list = new ArrayList<>();
            while (level > 0) {
                level--;
                TreeNode temp = queue.poll();
                list.add(temp);
                if (temp != null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                if (list.get(i) == null && list.get(j) == null) {
                    i++;
                    j--;
                    continue;
                }
                if (list.get(i) == null && list.get(j) != null) {
                    return false;
                }
                if (list.get(i) != null && list.get(j) == null) {
                    return false;
                }
                if (list.get(i).val != list.get(j).val) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
