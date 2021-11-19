package question0936_stamping_the_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

  private static class Node {
    Set<Integer> made, todo;  // made表示窗口中可以匹配的位置；todo表示窗口中不可以匹配的位置

    Node(Set<Integer> m, Set<Integer> t) {
      made = m;
      todo = t;
    }
  }

  public int[] movesToStamp(String stamp, String target) {
    int m = stamp.length(), n = target.length();
    Queue<Integer> canBePrinted = new LinkedList<>();
    boolean[] done = new boolean[n];
    Stack<Integer> ans = new Stack<>();
    List<Node> nodeList = new ArrayList<>();

    for (int i = 0; i <= n - m; i++) {
      Set<Integer> made = new HashSet<>(), todo = new HashSet<>();
      for (int j = 0; j < m; j++) {
        if (target.charAt(i + j) == stamp.charAt(j)) {
          made.add(i + j);
        } else {
          todo.add(i + j);
        }
      }
      nodeList.add(new Node(made, todo));
      if (todo.isEmpty()) {
        ans.push(i);
        for (int j = i; j < i + m; ++j) {
          if (!done[j]) {
            canBePrinted.add(j);
            done[j] = true;
          }
        }
      }
    }
    while (!canBePrinted.isEmpty()) {
      int i = canBePrinted.poll();
      for (int j = Math.max(0, i - m + 1); j <= Math.min(n - m, i); ++j) {
        if (nodeList.get(j).todo.contains(i)) {
          nodeList.get(j).todo.remove(i);
          if (nodeList.get(j).todo.isEmpty()) {
            ans.push(j);
            for (int k : nodeList.get(j).made) {
              if (!done[k]) {
                canBePrinted.add(k);
                done[k] = true;
              }
            }
          }
        }
      }
    }
    for (boolean value : done) {
      if (!value) {
        return new int[0];
      }
    }
    int[] result = new int[ans.size()];
    int t = 0;
    while (!ans.isEmpty()) {
      result[t++] = ans.pop();
    }
    return result;
  }

}