package lcci0409_bst_sequences;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右孩子由root.val来区分，因此只需要保证左孩子节点的相对顺序和右孩子节点的相对顺序即可，左右孩子节点的顺序可以交错。
 *
 * 执行用时：6ms，击败71.08%。消耗内存：41.1MB，击败100.00%。
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (null == root) {
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> leftResult = BSTSequences(root.left), rightResult = BSTSequences(root.right);
        for (List<Integer> leftList : leftResult) {
            for (List<Integer> rightList : rightResult) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                merge(leftList, rightList, 0, 0, list);
            }
        }
        return result;
    }

    private void merge(List<Integer> leftList, List<Integer> rightList, int index1, int index2, List<Integer> list) {
        if (index1 == leftList.size() && index2 == rightList.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (index1 == leftList.size()) {
            List<Integer> tmp = new ArrayList<>(list);
            for (int i = index2; i < rightList.size(); i++) {
                tmp.add(rightList.get(i));
            }
            result.add(tmp);
        } else if (index2 == rightList.size()) {
            List<Integer> tmp = new ArrayList<>(list);
            for (int i = index1; i < leftList.size(); i++) {
                tmp.add(leftList.get(i));
            }
            result.add(tmp);
        } else {
            list.add(leftList.get(index1));
            merge(leftList, rightList, index1 + 1, index2, list);
            list.remove(list.size() - 1);
            list.add(rightList.get(index2));
            merge(leftList, rightList, index1, index2 + 1, list);
            list.remove(list.size() - 1);
        }
    }
}