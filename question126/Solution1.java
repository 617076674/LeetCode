package question126;

import java.util.*;

public class Solution1 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> retListList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return retListList;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        HashMap<String, List<String>> from = new HashMap<>();
        List<String> visited = new ArrayList<>();
        HashMap<Integer, List<Integer>> nextWords = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            nextWords.put(i, new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (hasPath(wordList.get(i).toCharArray(), wordList.get(j).toCharArray())) {
                    nextWords.get(i).add(j);
                    nextWords.get(j).add(i);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<String> tempVisited = new ArrayList<>();
            while (levelCount-- > 0) {
                String temp = queue.poll();
                int n = wordList.indexOf(temp);
                List<Integer> nextWord = nextWords.get(n);
                for (int i = 0; i < nextWord.size(); i++) {
                    String string = wordList.get(nextWord.get(i));
                    if (!visited.contains(string)) {
                        if (!from.containsKey(string)) {
                            tempVisited.add(string);
                            queue.add(string);
                        }
                        if (from.containsKey(string)) {
                            List<String> tempList = from.get(string);
                            tempList.add(temp);
                            from.put(string, tempList);
                        } else {
                            List<String> tempList = new ArrayList<>();
                            tempList.add(temp);
                            from.put(string, tempList);
                        }
                    }
                }
            }
            for (String string : tempVisited) {
                visited.add(string);
            }
            if (visited.contains(endWord)) {
                break;
            }
        }
        from.put(beginWord, null);
        dfs(beginWord, endWord, new ArrayList<>(), from, retListList);
        return retListList;
    }

    private void dfs(String beginWord, String curWord, List<String> tempList, HashMap<String, List<String>> from, List<List<String>> templistList) {
        if (curWord.equals(beginWord)) {
            tempList.add(curWord);
            Collections.reverse(tempList);
            templistList.add(tempList);
            return;
        }
        tempList.add(curWord);
        if (from.get(curWord) != null) {
            for (String string : from.get(curWord)) {
                dfs(beginWord, string, new ArrayList<>(tempList), from, templistList);
            }
        }
    }

    private boolean hasPath(char[] arr1, char[] arr2) {
        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }

}

