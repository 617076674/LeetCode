package question2038_remove_colored_pieces_if_both_neighbors_are_the_same_color;

public class Solution {

  public boolean winnerOfGame(String colors) {
    int alice = 0, bob = 0;
    for (int i = 0; i < colors.length(); i++) {
      char c = colors.charAt(i);
      int j = i;
      while (j + 1 < colors.length() && colors.charAt(j + 1) == c) {
        j++;
      }
      if (c == 'A') {
        alice += Math.max(0, j - i - 1);
      } else {
        bob += Math.max(0, j - i - 1);
      }
      i = j;
    }
    return alice >= bob + 1;
  }

}