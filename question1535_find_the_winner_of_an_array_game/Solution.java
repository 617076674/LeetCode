package question1535_find_the_winner_of_an_array_game;

public class Solution {

  public int getWinner(int[] arr, int k) {
    int first = arr[0], last = -1, len = 0;
    for (int i = 1; i < arr.length; i++) {
      int max = Math.max(first, arr[i]);
      first = max;
      if (max == last) {
        len++;
      } else {
        last = max;
        len = 1;
      }
      if (len == k) {
        return max;
      }
    }
    return first;
  }

}