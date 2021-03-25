package question0692_top_k_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
      int freq1 = map.get(s1), freq2 = map.get(s2);
      if (freq1 == freq2) {
        return s2.compareTo(s1);
      }
      return freq1 - freq2;
    });
    for (String word : map.keySet()) {
      pq.add(word);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(0, pq.poll());
    }
    return result;
  }

}