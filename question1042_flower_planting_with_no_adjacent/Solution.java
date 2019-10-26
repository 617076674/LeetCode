package question1042_flower_planting_with_no_adjacent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用邻接表构建图。对于每一个节点依次染色，由于没有花园有 3 条以上的路径可以进入或者离开，所以每一个节点的颜色一定是[1, 2, 3, 4]中的一种。
 *
 * 时间复杂度和空间复杂度均是O(N + E)，其中E是paths数组的长度。
 *
 * 执行用时：59ms，击败59.34%。消耗内存：53.8MB，击败100.00%。
 */
public class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(); //用邻接表构建我们的图
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            //查看当前节点的所有邻接点的色彩
            for (int tmp : graph.get(i)) {
                used[result[tmp]] = true;
            }
            //为当前节点染色
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    result[i] = j;
                }
            }
        }
        return result;
    }
}