package question0855_exam_room;

import java.util.TreeSet;

public class ExamRoom {

  private int N;

  private TreeSet<Integer> students = new TreeSet<>();

  public ExamRoom(int N) {
    this.N = N;
  }

  public int seat() {
    int student = 0;
    if (!students.isEmpty()) {
      int gap = students.first();
      Integer prev = null;
      for (int s: students) {
        if (prev != null) {
          int mid = prev + ((s - prev) >> 1);
          int tempGap = Math.min(mid - prev, s - mid);
          if (tempGap > gap) {
            student = mid;
            gap = tempGap;
          }
        }
        prev = s;
      }
      if (N - 1 - students.last() > gap) {
        student = N - 1;
      }
    }
    students.add(student);
    return student;
  }

  public void leave(int p) {
    students.remove(p);
  }

}