package question0630_course_schedule_iii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution {

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
    PriorityQueue<Integer> queue = new PriorityQueue<>((cost1, cost2) -> cost2 - cost1);
    int time = 0;
    for (int[] course : courses) {
      if (time + course[0] <= course[1]) {
        queue.offer(course[0]);
        time += course[0];
      } else if (!queue.isEmpty() && queue.peek() > course[0]) {
        time += course[0] - queue.poll();
        queue.offer(course[0]);
      }
    }
    return queue.size();
  }

}