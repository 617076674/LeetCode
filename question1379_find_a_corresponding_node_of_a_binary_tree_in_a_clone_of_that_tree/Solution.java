package question1379_find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<Boolean> turnLeftList;

  private List<Boolean> tmpTurnLeftList = new ArrayList<>();

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
                                      final TreeNode target) {
    findTargetInOriginal(original, target);
    TreeNode cur = cloned;
    for (int i = 0; i < turnLeftList.size(); i++) {
      if (turnLeftList.get(i)) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    return cur;
  }

  private void findTargetInOriginal(TreeNode original, TreeNode target) {
    if (null == original || null != turnLeftList) {
      return;
    }
    if (target == original) {
      turnLeftList = new ArrayList<>(tmpTurnLeftList);
      return;
    }
    tmpTurnLeftList.add(true);
    findTargetInOriginal(original.left, target);
    tmpTurnLeftList.remove(tmpTurnLeftList.size() - 1);
    tmpTurnLeftList.add(false);
    findTargetInOriginal(original.right, target);
    tmpTurnLeftList.remove(tmpTurnLeftList.size() - 1);
  }

}