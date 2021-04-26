package question1138_alphabet_board_path;

public class Solution {

  public String alphabetBoardPath(String target) {
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    for (int i = 0; i < target.length(); i++) {
      char c = target.charAt(i);
      int curRow = cur / 5, curCol = cur % 5, nextRow = (c - 'a') / 5, nextCol = (c - 'a') % 5;
      if (curRow == 5) {
          while (nextRow < curRow) {
              curRow--;
              sb.append('U');
          }
          while (nextCol < curCol) {
              curCol--;
              sb.append('L');
          }
          while (nextCol > curCol) {
              curCol++;
              sb.append('R');
          }
      } else {
          while (nextCol < curCol) {
              curCol--;
              sb.append('L');
          }
          while (nextCol > curCol) {
              curCol++;
              sb.append('R');
          }
          while (nextRow > curRow) {
              curRow++;
              sb.append('D');
          }
          while (nextRow < curRow) {
              curRow--;
              sb.append('U');
          }
      }
      sb.append('!');
      cur = c - 'a';
    }
    return sb.toString();
  }

    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath("leet"));
    }

}