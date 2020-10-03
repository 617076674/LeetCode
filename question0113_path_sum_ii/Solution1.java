package question0113_path_sum_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归。
 *
 * 执行用时：4ms，击败6.47%。消耗内存：39.6MB，击败11.89%。
 */
public class Solution1 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            listList.add(list);
            return listList;
        }
        List<List<Integer>> leftListList = pathSum(root.left, sum - root.val);
        List<List<Integer>> rightListList = pathSum(root.right, sum - root.val);
        for (List<Integer> tmpList : leftListList) {
            tmpList.addAll(0, list);
            listList.add(tmpList);
        }
        for (List<Integer> tmpList : rightListList) {
            tmpList.addAll(0, list);
            listList.add(tmpList);
        }
        return listList;
    }

}