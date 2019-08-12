package question0314;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author qianyihui
 * @date 2019-08-12
 *
 * 用TreeMap先根据水平方向由小到大的坐标进行存储，根节点水平方向坐标为0，往左为负，往右为正。
 * TreeMap中的value又是一个Map<Integer, List<Integer>>，这个Map也是一个TreeMap，是按
 * 垂直方向由小到大的坐标进行存储，根节点的垂直方向坐标为0，往下为正。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：11ms，击败36.36%。消耗内存：37.1MB，击败100.00%。
 */
public class Solution {
    private Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        verticalOrder(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Map<Integer, List<Integer>> tmpMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> tmpList : tmpMap.values()) {
                list.addAll(tmpList);
            }
            result.add(list);
        }
        return result;
    }

    private void verticalOrder(TreeNode root, int index, int height) {
        if (root == null) {
            return;
        }
        if (map.containsKey(index)) {
            Map<Integer, List<Integer>> tmpMap = map.get(index);
            if (tmpMap.containsKey(height)) {
                tmpMap.get(height).add(root.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                tmpMap.put(height, list);
            }
        } else {
            Map<Integer, List<Integer>> tmpMap = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            tmpMap.put(height, list);
            map.put(index, tmpMap);
        }
        verticalOrder(root.left, index - 1, height + 1);
        verticalOrder(root.right, index + 1, height + 1);
    }
}
