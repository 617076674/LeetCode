package question0207.Java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序。
 *
 * 时间复杂度是O(n + e)，其中n为图中的点数，即课程数numCourses，e为图中的边数，即prerequisites数组的长度。
 *
 * 执行用时：220ms，击败9.19%。消耗内存：81MB，击败5.11%。
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int num = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < numCourses; v++) {
                if (graph[u][v] != 0) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
            num++;
        }
        return num == numCourses;
    }
}
