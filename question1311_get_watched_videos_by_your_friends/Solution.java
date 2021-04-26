package question1311_get_watched_videos_by_your_friends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends,
                                             int id, int level) {
    int n = watchedVideos.size();
    boolean[][] graph = new boolean[n][n];
    for (int i = 0; i < friends.length; i++) {
      for (int j = 0; j < friends[i].length; j++) {
        graph[i][friends[i][j]] = graph[friends[i][j]][i] = true;
      }
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(id);
    visited[id] = true;
    while (!queue.isEmpty()) {
      if (level == 0) {
        break;
      }
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        for (int j = 0; j < n; j++) {
          if (!visited[j] && graph[cur][j]) {
            visited[j] = true;
            queue.add(j);
          }
        }
      }
      level--;
    }
    Map<String, Integer> video2Freq = new HashMap<>();
    Set<String> set = new HashSet<>();
    while (!queue.isEmpty()) {
      int index = queue.poll();
      set.addAll(watchedVideos.get(index));
      for (int i = 0; i < watchedVideos.get(index).size(); i++) {
        video2Freq.put(watchedVideos.get(index).get(i),
            video2Freq.getOrDefault(watchedVideos.get(index).get(i), 0) + 1);
      }
    }
    List<String> result = new ArrayList<>(set);
    Collections.sort(result, (video1, video2) -> {
      int freq1 = video2Freq.get(video1), freq2 = video2Freq.get(video2);
      if (freq1 == freq2) {
        return video1.compareTo(video2);
      }
      return freq1 - freq2;
    });
    return result;
  }

}