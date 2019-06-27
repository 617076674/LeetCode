package question0508;

import java.util.*;

/**
 * @author qianyihui
 * @date 2019-06-27
 *
 * 递归求和，用哈希表记录所求和出现的次数。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：15ms，击败63.54%。消耗内存：40.5MB，击败67.21%。
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) { //对空树进行特殊处理
            return new int[0];
        }
        fillMap(getTreeNodeSum(root));
        int max = 0;
        for (Integer integer : map.values()) {
            max = Math.max(max, integer);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer).equals(max)) {
                list.add(integer);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int getTreeNodeSum(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        int left = getTreeNodeSum(treeNode.left);
        if (treeNode.left != null) {    //空节点的0不要计算在内
            fillMap(left);
        }
        int right = getTreeNodeSum(treeNode.right);
        if (treeNode.right != null) {   //空节点的0不要计算在内
            fillMap(right);
        }
        return left + right + treeNode.val;
    }

    private void fillMap(int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }
}
