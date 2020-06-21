package question0943_find_the_shortest_superstring;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力法回溯。
 *
 * 时间复杂度是 O(n!)，其中 n 为数组 A 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：1747ms，击败5.19%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution1 {
    private List<Integer> bestPath;

    private int minLen = Integer.MAX_VALUE;

    private int[][] map;

    public String shortestSuperstring(String[] A) {
        map = new int[A.length][A.length];  // map[i][j] 表示将字符串 A[j] 拼接在字符串 A[i] 后面的新增长度
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    map[i][j] = A[j].length();
                    for (int k = 1; k < Math.min(A[i].length(), A[j].length()); k++) {
                        if (A[i].substring(A[i].length() - k).equals(A[j].substring(0, k))) {
                            map[i][j] = A[j].length() - k;
                        }
                    }
                }
            }
        }
        dfs(A, 0, 0, new ArrayList<>());
        StringBuilder sb = new StringBuilder(A[bestPath.get(0)]);
        for (int i = 1; i < bestPath.size(); i++) {
            sb.append(A[bestPath.get(i)].substring(A[bestPath.get(i)].length() - map[bestPath.get(i - 1)][bestPath.get(i)]));
        }
        return sb.toString();
    }

    private void dfs(String[] A, int used, int curLen, List<Integer> path) {
        if (curLen >= minLen) {
            return;
        }
        if (path.size() == A.length) {
            bestPath = new ArrayList<>(path);
            minLen = curLen;
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (((used >> i) & 1) == 0) {
                path.add(i);
                used |= (1 << i);
                dfs(A, used, path.size() == 1 ? A[i].length() : curLen + map[path.get(path.size() - 2)][i], path);
                used ^= (1 << i);
                path.remove(path.size() - 1);
            }
        }
    }
}