package question0126_word_ladder_ii;

import java.util.*;

/**
 * Dijkstra 最短路径算法。
 *
 * 执行用时：771ms，击败12.62%。消耗内存：41.7MB，击败90.00%。
 */
public class Solution2 {
    private List<Integer>[] graph, pre;

    private int[] distance;

    private List<List<String>> result = new ArrayList<>();

    private int begin, end;

    private boolean[] visited;

    private List<Integer> tmpList = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        end = wordList.indexOf(endWord);
        if (end == -1) {
            return result;
        }
        begin = wordList.indexOf(beginWord);
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.size() - 1;
        }
        graph = new List[wordList.size()];
        pre = new List[wordList.size()];
        visited = new boolean[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new ArrayList<>();
            pre[i] = new ArrayList<>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (hasPath(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        distance = new int[wordList.size()];
        dijkstra();
        dfs(end, wordList);
        return result;
    }

    private void dijkstra() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[begin] = 0;
        for (int i = 0; i < distance.length; i++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int j = 0; j < distance.length; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    u = j;
                }
            }
            if (u == -1) {
                return;
            }
            visited[u] = true;
            for (int j = 0; j < graph[u].size(); j++) {
                int v = graph[u].get(j);
                if (!visited[v]) {
                    if (distance[u] + 1 < distance[v]) {
                        distance[v] = distance[u] + 1;
                        pre[v].clear();
                        pre[v].add(u);
                    } else if (distance[u] + 1 == distance[v]) {
                        pre[v].add(u);
                    }
                }
            }
        }
    }

    private void dfs(int now, List<String> wordList) {
        if (now == begin) {
            tmpList.add(now);
            List<String> list = new ArrayList<>();
            for (int i = tmpList.size() - 1; i >= 0; i--) {
                list.add(wordList.get(tmpList.get(i)));
            }
            result.add(list);
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        tmpList.add(now);
        for (int i = 0; i < pre[now].size(); i++) {
            dfs(pre[now].get(i), wordList);
        }
        tmpList.remove(tmpList.size() - 1);
    }

    private boolean hasPath(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}