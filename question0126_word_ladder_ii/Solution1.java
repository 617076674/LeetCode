package question0126_word_ladder_ii;

import java.util.*;

/**
 * 广搜。
 *
 * 执行用时：591ms，击败21.21%。消耗内存：41.6MB，击败90.00%。
 */
public class Solution1 {
    private List<Integer>[] graph;

    private int[] distance;

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return result;
        }
        int begin = wordList.indexOf(beginWord);
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.size() - 1;
        }
        graph = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (hasPath(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(begin);
        distance = new int[wordList.size()];
        Arrays.fill(distance, -1);
        distance[begin] = 0;
        while (!queue.isEmpty()) {
            if (distance[end] != -1) {
                break;
            }
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int now = queue.poll();
                for (int next : graph[now]) {
                    if (distance[next] == -1) {
                        distance[next] = distance[now] + 1;
                        queue.add(next);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(begin);
        dfs(begin, end, wordList, list);
        return result;
    }

    private void dfs(int now, int end, List<String> wordList, List<Integer> list) {
        if (now == end) {
            List<String> tmp = new ArrayList<>();
            for (int num : list) {
                tmp.add(wordList.get(num));
            }
            result.add(tmp);
            return;
        }
        for (int next : graph[now]) {
            if (distance[next] == distance[now] + 1) {
                list.add(next);
                dfs(next, end, wordList, list);
                list.remove(list.size() - 1);
            }
        }
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