package question0332_reconstruct_itinerary;

import java.util.*;

/**
 * 严谨地说，一个连通有向图G有欧拉路径，指存在一个顶点，从它出发，沿着有向边的方向，可以不重复地遍历图中所有的边。
 *
 * 因为每个顶点都要访问一次，每条边都要访问一次，时间复杂度是O(V+E)，其中V是顶点数，E是边数。还要记得对临接点排序的时间复杂度O(ElogE)。
 * 算法整体时间复杂度为O(ElogE)；如果整个图是链式的，那么调用栈最深，空间复杂度应为 O(E)。
 *
 * 执行用时：6ms，击败100.00%。消耗内存：43.7MB，击败68.63%。
 */
import java.util.*;

/**
 * 严谨地说，一个连通有向图G有欧拉路径，指存在一个顶点，从它出发，沿着有向边的方向，可以不重复地遍历图中所有的边。
 *
 * Hierholzer 算法：
 *
 * Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
 * （1）从起点出发，进行深度优先搜索。
 * （2）每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
 * （3）如果没有可移动的路径，则将所在节点加入到栈中，并返回。
 *
 * 因为每个顶点都要访问一次，每条边都要访问一次，时间复杂度是O(V+E)，其中V是顶点数，E是边数。还要记得对临接点排序的时间复杂度O(ElogE)。
 * 算法整体时间复杂度为O(ElogE)；如果整个图是链式的，那么调用栈最深，空间复杂度应为 O(E)。
 *
 * 执行用时：6ms，击败100.00%。消耗内存：43.7MB，击败68.63%。
 */
public class Solution {

    private Map<String, PriorityQueue<String>> graph = new HashMap<>();

    private List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (null == tickets || tickets.isEmpty()) {
            return result;
        }
        //构建图
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }

    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void dfs(String begin) {
        PriorityQueue<String> pq = graph.get(begin);
        while (null != pq && !pq.isEmpty()) {
            String destination = pq.poll();
            dfs(destination);
        }
        result.add(0, begin); // 逆序插入
    }
    
}