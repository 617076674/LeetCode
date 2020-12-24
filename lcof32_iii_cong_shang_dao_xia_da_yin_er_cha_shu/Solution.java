package lcof32_iii_cong_shang_dao_xia_da_yin_er_cha_shu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode now = queue.poll();
                list.add(now.val);
                if (null != now.left) {
                    queue.add(now.left);
                }
                if (null != now.right) {
                    queue.add(now.right);
                }
            }
            if (reverse) {
                Collections.reverse(list);
            }
            result.add(list);
            reverse = !reverse;
        }
        return result;
    }
}