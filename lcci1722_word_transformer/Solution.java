package lcci1722_word_transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

  private int[] h, ne, e;

  private int edgeIdx;

  void add(int a, int b) {
    e[edgeIdx] = b;
    ne[edgeIdx] = h[a];
    h[a] = edgeIdx++;
  }

  private int[] pre;

  public static void main(String[] args) {
    String beginWord = "a";
    String endWord = "c";
    String[] words = {"a", "b", "c"};
    List<String> wordList = new ArrayList<>(words.length);
    for (String word : words) {
      wordList.add(word);
    }
    System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
  }

  private int f(String curWord, String endWord) {
    int diff = 0;
    for (int i = 0; i < curWord.length(); i++) {
      if (curWord.charAt(i) != endWord.charAt(i)) {
        diff++;
      }
    }
    return diff;
  }

  private static class Status {

    int fValue;
    int idx;
    int pre;
    int dist;

    public Status(int fValue, int idx, int pre, int dist) {
      this.fValue = fValue;
      this.idx = idx;
      this.pre = pre;
      this.dist = dist;
    }

  }

  public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<String> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    Map<String, Integer> str2Idx = new HashMap<>();
    Map<Integer, String> idx2Str = new HashMap<>();
    int idx = 0;
    wordList.add(beginWord);
    for (String word : wordList) {
      if (set.add(word)) {
        str2Idx.put(word, idx);
        idx2Str.put(idx, word);
        idx++;
      }
    }
    if (!set.contains(endWord)) {
      return result;
    }
    h = new int[idx];
    Arrays.fill(h, -1);
    int eCnt = wordList.size() * (wordList.size() + 1) / 2;
    ne = new int[eCnt];
    e = new int[eCnt];
    pre = new int[idx];
    Arrays.fill(pre, -1);
    for (int i = 0; i < wordList.size(); i++) {
      for (int j = i + 1; j < wordList.size(); j++) {
        if (canConnect(wordList.get(i), wordList.get(j))) {
          add(str2Idx.get(wordList.get(i)), str2Idx.get(wordList.get(j)));
          add(str2Idx.get(wordList.get(j)), str2Idx.get(wordList.get(i)));
        }
      }
    }
    int begin = str2Idx.get(beginWord), end = str2Idx.get(endWord);
    PriorityQueue<Status> queue =
        new PriorityQueue<>(Comparator.comparingInt(status -> status.fValue));
    queue.add(new Status(f(idx2Str.get(begin), endWord), begin, -1, 0));
    boolean[] visited = new boolean[wordList.size()];
    while (!queue.isEmpty()) {
      Status cur = queue.poll();
      if (visited[cur.idx]) {
        continue;
      }
      visited[cur.idx] = true;
      pre[cur.idx] = cur.pre;
      if (cur.idx == end) {
        int temp = end;
        while (temp != -1) {
          result.add(idx2Str.get(temp));
          temp = pre[temp];
        }
        Collections.reverse(result);
        return result;
      }
      for (int i = h[cur.idx]; i != -1; i = ne[i]) {
        int j = e[i];
        queue.add(new Status(f(idx2Str.get(cur.idx), endWord) + cur.dist + 1, j, cur.idx,
            cur.dist + 1));
      }
    }
    return result;
  }

  private static boolean canConnect(String s1, String s2) {
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (diff == 1) {
          return false;
        }
        diff++;
      }
    }
    return diff == 1;
  }

}