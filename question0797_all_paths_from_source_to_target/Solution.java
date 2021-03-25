package question0797_all_paths_from_source_to_target;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path);
        return result;
    }

    private void dfs(int now, int[][] graph, List<Integer> list) {
        if (now == graph.length - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[now]) {
            list.add(next);
            dfs(next, graph, list);
            list.remove(list.size() - 1);
        }
    }

}