package question0207_course_schedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序。
 *
 * 时间复杂度是 O(n + e)，其中 n 为图中的点数，即课程数 numCourses，e 为图中的边数，即 prerequisites 数组的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：18ms，击败41.07%。消耗内存：42.8MB，击败85.00%。
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = true;
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (graph[now][i]) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
            index++;
        }
        return index == numCourses;
    }
}