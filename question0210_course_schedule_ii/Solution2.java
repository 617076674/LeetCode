package question0210_course_schedule_ii;

/**
 * 深度优先搜索。
 *
 * 时间复杂度是 O(n + e)，其中 n 为图中的点数，即课程数 numCourses，e 为图中的边数，即 prerequisites 数组的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：20ms，击败39.83%。消耗内存：43.6MB，击败85.00%。
 */
public class Solution2 {
    // status[i] = 0, 节点 i 未被访问
    // status[i] = 1, 节点 i 已被当前 DFS 访问
    // status[i] = 2, 节点 i 已被其他 DFS 访问
    private int[] status, result;

    private boolean[][] graph;

    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        status = new int[numCourses];
        result = new int[numCourses];
        graph = new boolean[numCourses][numCourses];
        index = graph.length - 1;
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) {
                return new int[0];
            }
        }
        return result;
    }

    /**
     * 判断当前 DFS 是否存在环
     */
    private boolean dfs(int now) {
        if (status[now] == 1) {
            return true;
        } else if (status[now] == 2) {
            return false;
        }
        status[now] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[now][i] && dfs(i)) {
                return true;
            }
        }
        status[now] = 2;    //在所有节点都搜索完成之后就可以加入 result 数组
        result[index--] = now;
        return false;
    }
}