package question1298_maximum_candies_you_can_get_from_boxes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int len = status.length;
    boolean[] visited = new boolean[len]; // 记录盒子是否被拆开
    Set<Integer> haveBoxes = new HashSet<>(); // 记录我们拥有的所有盒子
    Set<Integer> haveKeys = new HashSet<>();  // 记录我们拥有的所有钥匙
    Queue<Integer> queue = new LinkedList<>();
    for (int box : initialBoxes) {
      haveBoxes.add(box);
      if (status[box] == 1) { // 如果盒子可以打开则加入队列
        queue.offer(box);
        visited[box] = true;
      }
    }
    int result = 0;
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      result += candies[cur];
      int[] curKeys = keys[cur];
      int[] curBoxes = containedBoxes[cur];
      for (int key : curKeys) { // 遍历钥匙
        haveKeys.add(key);  // 加入我们拥有的钥匙列表
        if (!visited[key] && haveBoxes.contains(key)) {
          // 盒子没被拆开过 且 我们有对应的钥匙
          queue.offer(key);
          visited[key] = true;
        }
      }
      for (int box : curBoxes) {  // 遍历内含盒子
        haveBoxes.add(box); // 加入我们拥有的盒子列表
        if (!visited[box] && (haveKeys.contains(box) || status[box] == 1)) {
          // 盒子没被拆开过 且 (我们有对应的钥匙 或者 盒子是打开状态)
          queue.offer(box);
          visited[box] = true;
        }
      }
    }
    return result;
  }

}