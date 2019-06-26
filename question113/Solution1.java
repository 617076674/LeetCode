package question113;

import java.util.ArrayList;
import java.util.List;

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
        for (List<Integer> tempList : leftListList) {
            tempList.addAll(0, list);
            listList.add(tempList);
        }
        for (List<Integer> tempList : rightListList) {
            tempList.addAll(0, list);
            listList.add(tempList);
        }
        return listList;
    }
}
