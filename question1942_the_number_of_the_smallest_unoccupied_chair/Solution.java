package question1942_the_number_of_the_smallest_unoccupied_chair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int smallestChair(int[][] times, int targetFriend) {
    Queue<Integer> queue = new PriorityQueue<>();
    Integer[] people = new Integer[times.length];
    for (int i = 0; i < people.length; i++) {
      people[i] = i;
    }
    Arrays.sort(people, (person1, person2) -> {
      if (times[person1][0] == times[person2][0]) {
        return times[person1][1] - times[person2][1];
      }
      return times[person1][0] - times[person2][0];
    });
    int index = 0;
    Queue<Integer> peopleInChair =
        new PriorityQueue<>(Comparator.comparingInt(person -> times[person][1]));
    Map<Integer, Integer> person2Position = new HashMap<>();
    for (int i = 0; i < people.length; i++) {
      while (!peopleInChair.isEmpty() && times[peopleInChair.peek()][1] <= times[people[i]][0]) {
        queue.add(person2Position.get(peopleInChair.poll()));
      }
      peopleInChair.add(people[i]);
      if (queue.isEmpty()) {
        person2Position.put(people[i], index++);
      } else {
        person2Position.put(people[i], queue.poll());
      }
      if (people[i] == targetFriend) {
        return person2Position.get(people[i]);
      }
    }
    return -1;
  }

}