package question127;

import java.util.*;

public class Solution1 {
    class LevelWord {
        String word;
        int level;
        public LevelWord(String word, int level) {
            this.word = word;
            this.level = level;
        }

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if(end == -1) {
            return 0;
        }
        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        boolean[][] nextWords = new boolean[wordList.size()][wordList.size()];
        HashMap<String, Boolean> visited = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(hasPath(wordList.get(i).toCharArray(), wordList.get(j).toCharArray())) {
                    nextWords[i][j] = nextWords[j][i] =	true;
                }
            }
            visited.put(wordList.get(i), false);
        }
        Queue<LevelWord> queue = new LinkedList<>();
        queue.add(new LevelWord(beginWord, 0));
        visited.put(beginWord, true);
        while(!queue.isEmpty()) {
            LevelWord temp = queue.poll();
            if(temp.word.equals(endWord)) {
                return temp.level + 1;
            }
            List<String> nextWord = new ArrayList<>();
            int n = wordList.indexOf(temp.word);
            for (int i = 0; i < nextWords[n].length; i++) {
                if(nextWords[n][i]) {
                    nextWord.add(wordList.get(i));
                }
            }
            for (int i = 0; i < nextWord.size(); i++) {
                String nextTemp = nextWord.get(i);
                if(!visited.get(nextTemp)) {
                    queue.add(new LevelWord(nextTemp, temp.level + 1));
                    visited.put(nextTemp, true);
                }
            }
        }
        return 0;
    }

    private boolean hasPath(char[] arr1, char[] arr2) {
        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                diff++;
            }
        }
        if(diff == 1) {
            return true;
        }
        return false;
    }
}

