package question0715_range_module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class RangeModule {

  private static class Interval implements Comparable<Interval> {

    int left;
    int right;

    public Interval(int left, int right) {
      this.left = left;
      this.right = right;
    }

    public int compareTo(Interval interval) {
      if (this.right == interval.right) {
        return this.left - interval.left;
      }
      return this.right - interval.right;
    }

  }

  private TreeSet<Interval> ranges = new TreeSet<>();

  public RangeModule() {
  }

  public void addRange(int left, int right) {
    Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
    while (itr.hasNext()) {
      Interval iv = itr.next();
      if (right < iv.left) {
        break;
      }
      left = Math.min(left, iv.left);
      right = Math.max(right, iv.right);
      itr.remove();
    }
    ranges.add(new Interval(left, right));
  }

  public boolean queryRange(int left, int right) {
    Interval iv = ranges.higher(new Interval(0, left));
    return (iv != null && iv.left <= left && right <= iv.right);
  }

  public void removeRange(int left, int right) {
    Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
    List<Interval> todo = new ArrayList<>();
    while (itr.hasNext()) {
      Interval iv = itr.next();
      if (right < iv.left) {
        break;
      }
      if (iv.left < left) {
        todo.add(new Interval(iv.left, left));
      }
      if (right < iv.right) {
        todo.add(new Interval(right, iv.right));
      }
      itr.remove();
    }
    ranges.addAll(todo);
  }

}