package question1825_finding_mk_average;

import java.util.PriorityQueue;

public class MKAverage {

  private int m, k, midLen, size, midSum, putIndex, takeIndex;

  private int[] nums;

  // MAX PART, is a min heap
  private PriorityQueue<Integer> maxPart = new PriorityQueue<>();

  // MIN PART, is a max heap
  private PriorityQueue<Integer> minPart = new PriorityQueue<>((o1, o2) -> o2 - o1);

  // MID PART, min heap
  private PriorityQueue<Integer> midPartMIN = new PriorityQueue<>();

  // MID PART, max heap
  private PriorityQueue<Integer> midPartMAX = new PriorityQueue<>((o1, o2) -> o2 - o1);

  public MKAverage(int m, int k) {
    this.m = m;
    this.k = k;
    this.midLen = m - (k << 1); // at least one
    this.nums = new int[m];
  }

  public void addElement(int num) {
    // remove oldest one first
    if (size == m) {
      Integer removed = nums[takeIndex++];
      if (takeIndex == m) {
        takeIndex = 0;
      }
      if (removed > midPartMAX.peek()) {
        maxPart.remove(removed);
      } else if (removed < midPartMIN.peek()) {
        minPart.remove(removed);
      } else {
        midPartMIN.remove(removed);
        midPartMAX.remove(removed);
        midSum -= removed;
      }
    } else {
      size++;
    }
    nums[putIndex++] = num;
    if (putIndex == m) {
      putIndex = 0;
    }
    if (!maxPart.isEmpty() && num > maxPart.peek()) { // must add to max part
      maxPart.offer(num);
      if (maxPart.size() > k) {
        maxToMid();
      }
    } else if (!minPart.isEmpty() && num < minPart.peek()) { // must add to min part
      minPart.offer(num);
      if (minPart.size() > k) {
        minToMid();
      }
    } else {
      midPartMIN.offer(num);
      midPartMAX.offer(num);
      midSum += num;
    }
    if (midPartMIN.size() > midLen) {
      if (minPart.size() < k) {
        midToMin();
      } else {
        midToMax();
      }
    }
  }

  public int calculateMKAverage() {
    if (size < m) {
      return -1;
    }
    return midSum / midLen;
  }

  /**
   * Move element from MAX to MID
   */
  private void maxToMid() {
    Integer toMid = maxPart.poll();
    midPartMAX.offer(toMid);
    midPartMIN.offer(toMid);
    midSum += toMid;
  }

  /**
   * Move element from MIN to MID
   */
  private void minToMid() {
    Integer toMid = minPart.poll();
    midPartMAX.offer(toMid);
    midPartMIN.offer(toMid);
    midSum += toMid;
  }

  /**
   * Move element to MAX part
   */
  private void midToMax() {
    Integer toMax = midPartMAX.poll();
    midPartMIN.remove(toMax);
    maxPart.offer(toMax);
    midSum -= toMax;
  }

  /**
   * Move element to MIN part
   */
  private void midToMin() {
    Integer toMin = midPartMIN.poll();
    midPartMAX.remove(toMin);
    minPart.offer(toMin);
    midSum -= toMin;
  }

}