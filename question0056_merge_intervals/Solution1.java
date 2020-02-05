package question0056_merge_intervals;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 并查集。
 *
 * 时间复杂度是O(n ^ 2)，其中n为区间数。空间复杂度是O(n)。
 *
 * 执行用时：718ms，击败5.00%。消耗内存：61.8MB，击败5.04%。
 */
public class Solution1 {
    private int[] parent;   //并查集

    private int n;

    public int[][] merge(int[][] intervals) {
        if (null == intervals || (n = intervals.length) == 0 || n == 1) {
            return intervals;
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1])
                        || (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][0])) {
                    union(i, j);
                }
            }
        }
        Set<Integer> parentSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parentSet.add(findParent(i));
        }
        int[][] result = new int[parentSet.size()][2];
        int index = 0;
        for (Integer tmp : parentSet) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (findParent(i) == tmp) {
                    max = Math.max(max, intervals[i][1]);
                    min = Math.min(min, intervals[i][0]);
                }
            }
            result[index][0] = min;
            result[index][1] = max;
            index++;
        }
        return result;
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }
}