package question1273_delete_tree_nodes;

import java.util.*;

/**
 * 时间复杂度和空间复杂度均是 O(nodes)。
 *
 * 执行用时：17ms，击败52.31%。消耗内存：42.7MB，击败100.00%。
 */
public class Solution {
    private Integer[] memo;

    private List<Integer>[] map;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        memo = new Integer[nodes];
        map = new List[nodes];
        for (int i = 1; i < parent.length; i++) {
            if (map[parent[i]] == null) {
                map[parent[i]] = new ArrayList<>();
            }
            map[parent[i]].add(i);
        }
        memo[0] = deleteTreeNodes(value, 0);
        if (memo[0] == 0) {
            return 0;
        }
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            List<Integer> children = map[queue.poll()];
            if (null != children) {
                for (int child : children) {
                    if (memo[child] != 0) {
                        result++;
                        queue.add(child);
                    }
                }
            }
        }
        return result;
    }

    private int deleteTreeNodes(int[] value, int index) {
        if (null != memo[index]) {
            return memo[index];
        }
        int result = value[index];
        List<Integer> children = map[index];
        if (null != children) {
            for (int child : children) {
                result += deleteTreeNodes(value, child);
            }
        }
        memo[index] = result;
        return result;
    }
}