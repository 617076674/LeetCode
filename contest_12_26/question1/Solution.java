package contest_12_26.question1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int countStudents(int[] students, int[] sandwiches) {
    Queue<Integer> queue = new LinkedList<>();
    for (int student : students) {
      queue.add(student);
    }
    int index = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        if (sandwiches[index] == queue.poll()) {
          index++;
        } else {
          queue.add(1 - sandwiches[index]);
        }
      }
      if (qSize == queue.size()) {
        return qSize;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] students = {1,1,1,0,0,1};
    int[] sandwiches = {1,0,0,0,1,1};
    System.out.println(new Solution().countStudents(students, sandwiches));
  }
}