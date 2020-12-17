package lcof32_i_cong_shang_dao_xia_da_yin_er_cha_shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public int[] levelOrder(TreeNode root) {
    if (null == root) {
      return new int[] {};
    }
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int qSize = queue.size();
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
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}