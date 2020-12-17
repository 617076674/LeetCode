package lcof32_ii_cong_shang_dao_xia_da_yin_er_cha_shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败95.19%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
            result.add(list);
        }
        return result;
    }
}