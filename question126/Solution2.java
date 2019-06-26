package question126;

import java.util.*;

public class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> retListList = new ArrayList<>();

        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return retListList;
        }

        int begin = wordList.indexOf(beginWord);
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.indexOf(beginWord);
        }

        int len = wordList.size();

        //建立邻接表
        HashMap<Integer, List<Integer>> nextWords = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nextWords.put(i, new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (hasPath(wordList.get(i), wordList.get(j))) {
                    nextWords.get(i).add(j);
                    nextWords.get(j).add(i);
                }
            }
        }

        HashMap<Integer, Integer> distance = new HashMap<>();
        //广度优先遍历bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(begin);
        distance.put(begin, 0);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();

            for (int i = 0; i < nextWords.get(temp).size(); i++) {
                if (!distance.containsKey(nextWords.get(temp).get(i))) {
                    distance.put(nextWords.get(temp).get(i), distance.get(temp) + 1);
                    queue.add(nextWords.get(temp).get(i));
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        list.add(begin);
        //深度优先遍历dfs
        dfs(nextWords, begin, end, distance, wordList, list, retListList);

        return retListList;
    }

    private void dfs(HashMap<Integer, List<Integer>> nextWords, Integer temp, Integer end,
                     HashMap<Integer, Integer> distance, List<String> wordList, List<Integer> list, List<List<String>> retListList) {
        if (list.size() > 0 && list.get(list.size() - 1).equals(end)) {
            retListList.add(getPath(list, wordList));
            return;
        }

        for (int i = 0; i < nextWords.get(temp).size(); i++) {
            if (distance.get(nextWords.get(temp).get(i)).equals(distance.get(temp) + 1)) {
                list.add(nextWords.get(temp).get(i));
                dfs(nextWords, nextWords.get(temp).get(i), end, distance, wordList, list, retListList);
                int index = list.size() - 1;
                list.remove(index);
            }
        }
        return;
    }

    private List<String> getPath(List<Integer> list, List<String> wordList) {
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            retList.add(wordList.get(list.get(i)));
        }
        return retList;
    }

    private boolean hasPath(String s1, String s2) {
        int diff = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
