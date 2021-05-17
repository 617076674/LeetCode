package question1625_lexicographically_smallest_string_after_applying_operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Solution {

  public String findLexSmallestString(String s, int a, int b) {
    TreeSet<String> set = new TreeSet<>();
    Queue<String> q = new LinkedList<>();
    set.add(s);
    q.offer(s);
    while (!q.isEmpty()) {
      String cur = q.poll();
      int len = cur.length();
      findLexSmallestStringHelper(cur.substring(len - b) + cur.substring(0, len - b), set, q);
      char[] arr = cur.toCharArray();
      for (int i = 1; i < len; i += 2) {
        arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
      }
      findLexSmallestStringHelper(new String(arr), set, q);
    }
    return set.first();
  }

  private static void findLexSmallestStringHelper(String s, TreeSet<String> set, Queue<String> q) {
    if (!set.contains(s)) {
      set.add(s);
      q.offer(s);
    }
  }

}