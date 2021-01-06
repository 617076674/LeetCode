package question1700_number_of_students_unable_to_eat_lunch;

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

}