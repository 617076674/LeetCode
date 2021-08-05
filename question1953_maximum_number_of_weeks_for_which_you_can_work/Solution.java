package question1953_maximum_number_of_weeks_for_which_you_can_work;

public class Solution {

  public long numberOfWeeks(int[] milestones) {
    long max = Integer.MIN_VALUE, other = 0;
    for (int milestone : milestones) {
      max = Math.max(max, milestone);
      other += milestone;
    }
    other -= max;
    if (max > other + 1) {
      return other + other + 1;
    }
    return other + max;
  }

}