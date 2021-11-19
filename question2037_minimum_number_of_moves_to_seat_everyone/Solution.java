package question2037_minimum_number_of_moves_to_seat_everyone;

import java.util.Arrays;

public class Solution {

  public int minMovesToSeat(int[] seats, int[] students) {
    Arrays.sort(seats);
    Arrays.sort(students);
    int result = 0;
    for (int i = 0; i < seats.length; i++) {
      result += Math.abs(seats[i] - students[i]);
    }
    return result;
  }

}