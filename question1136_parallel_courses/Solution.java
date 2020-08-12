package question1136_parallel_courses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序。
 *
 * 时间复杂度是 O(N + relations.length)。空间复杂度是 O(N * N)。
 *
 * 执行用时：8ms，击败64.38%。消耗内存：40.5MB，击败100.00%。
 */
public class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        int[] inDegree = new int[N];
        List<Integer>[] graph = new List[N];
        int learned = 0;
        for (int[] relation : relations) {
            int first = relation[0] - 1, second = relation[1] - 1;
            inDegree[second]++;
            if (graph[first] == null) {
                graph[first] = new ArrayList<>();
            }
            graph[first].add(second);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                learned++;
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                if (graph[now] != null) {
                    for (int next : graph[now]) {
                        inDegree[next]--;
                        if (inDegree[next] == 0) {
                            queue.add(next);
                            learned++;
                        }
                    }
                }
            }
            step++;
        }
        if (learned == N) {
            return step;
        }
        return -1;
    }
}