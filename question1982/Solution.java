package question1982;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private List<Integer> resultList;

    private static Map<Integer, List<Integer>> list2Map(List<Integer> list) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> indexes = result.get(list.get(i));
            if (null == indexes) {
                indexes = new ArrayList<>();
                indexes.add(i);
                result.put(list.get(i), indexes);
            } else {
                indexes.add(i);
            }
        }
        return result;
    }
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        List<Integer> initialList = new ArrayList<>();
        for (int i = 0; i < sums.length; i++) {
            initialList.add(sums[i]);
        }
        dfs(initialList, new ArrayList<>());
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sums = {340,1180,1157,325,-492,1165,-817,855,840,1672,0,23,832,1997,348,15};
        System.out.println(Arrays.toString(new Solution().recoverArray(3, sums)));
    }

    private void dfs(List<Integer> list, List<Integer> path) {
        if (null != resultList) {
            return;
        }
        if (list.size() == 2) {
            path.add(list.get(1) == 0 ? list.get(0) : list.get(1));
            resultList = new ArrayList<>(path);
            path.remove(path.size() - 1);
            return;
        }
        if (list.get(1) <= 0) {
            int maxNegative = list.get(0) - list.get(1);
            boolean[] visited = new boolean[list.size()];
            List<Integer> nextList = new ArrayList<>();
            Map<Integer, List<Integer>> sum2Indexes = list2Map(list);
            if (sum2Indexes.containsKey(maxNegative)) {
                for (int i = 0; i < list.size(); i++) {
                    if (visited[i]) {
                        continue;
                    }
                    List<Integer> indexes = sum2Indexes.get(list.get(i) - maxNegative);
                    if (null == indexes || indexes.isEmpty()) {
                        continue;
                    }
                    int removedIndex = indexes.remove(0);
                    visited[removedIndex] = true;
                    nextList.add(list.get(removedIndex));
                }
            }
            if (nextList.size() == list.size() / 2) {
                path.add(maxNegative);
                dfs(nextList, path);
                path.remove(path.size() - 1);
            }
            int minPositive = list.get(1) - list.get(0);
            visited = new boolean[list.size()];
            nextList = new ArrayList<>();
            sum2Indexes = list2Map(list);
            if (sum2Indexes.containsKey(minPositive)) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (visited[i]) {
                        continue;
                    }
                    List<Integer> indexes = sum2Indexes.get(list.get(i) - minPositive);
                    if (null == indexes || indexes.isEmpty()) {
                        continue;
                    }
                    int removedIndex = indexes.remove(0);
                    visited[removedIndex] = true;
                    nextList.add(list.get(removedIndex));
                }
                Collections.reverse(nextList);
            }
            if (nextList.size() == list.size() / 2) {
                path.add(minPositive);
                dfs(nextList, path);
                path.remove(path.size() - 1);
            }
        }
        if (list.get(list.size() - 2) >= 0) {
            int maxNegative = list.get(list.size() - 2) - list.get(list.size() - 1);
            boolean[] visited = new boolean[list.size()];
            List<Integer> nextList = new ArrayList<>();
            Map<Integer, List<Integer>> sum2Indexes = list2Map(list);
            if (sum2Indexes.containsKey(maxNegative)) {
                for (int i = 0; i < list.size(); i++) {
                    if (visited[i]) {
                        continue;
                    }
                    List<Integer> indexes = sum2Indexes.get(list.get(i) - maxNegative);
                    if (null == indexes || indexes.isEmpty()) {
                        continue;
                    }
                    int removedIndex = indexes.remove(0);
                    visited[removedIndex] = true;
                    nextList.add(list.get(removedIndex));
                }
            }
            if (nextList.size() == list.size() / 2) {
                path.add(maxNegative);
                dfs(nextList, path);
                path.remove(path.size() - 1);
            }
            int minPositive = list.get(list.size() - 1) - list.get(list.size() - 2);
            visited = new boolean[list.size()];
            nextList = new ArrayList<>();
            sum2Indexes = list2Map(list);
            if (sum2Indexes.containsKey(minPositive)) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (visited[i]) {
                        continue;
                    }
                    List<Integer> indexes = sum2Indexes.get(list.get(i) - minPositive);
                    if (null == indexes || indexes.isEmpty()) {
                        continue;
                    }
                    int removedIndex = indexes.remove(0);
                    visited[removedIndex] = true;
                    nextList.add(list.get(removedIndex));
                }
                Collections.reverse(nextList);
            }
            if (nextList.size() == list.size() / 2) {
                path.add(minPositive);
                dfs(nextList, path);
                path.remove(path.size() - 1);
            }
        }
    }

}