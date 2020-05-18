package question0210_course_schedule_ii;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序。
 *
 * 时间复杂度是 O(n + e)，其中 n 为图中的点数，即课程数 numCourses，e 为图中的边数，即 prerequisites 数组的长度。
 *
 * 执行用时：101ms，击败12.31%。消耗内存：81.4MB，击败5.13%。
 */
public class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result[index++] = now;
            for (int i = 0; i < numCourses; i++) {
                if (graph[now][i] != 0) {
                    if (--inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}