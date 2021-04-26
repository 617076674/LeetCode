package question1812_determine_color_of_a_chessboard_square;

public class Solution {

  public boolean squareIsWhite(String coordinates) {
    // + 1 是为了将坐标映射成 [1, n]，而不是 [0, n - 1]
    int x = coordinates.charAt(0) - 'a' + 1;
    int y = coordinates.charAt(1) - '0';
    // 根据行和列的奇偶性来判断返回值
    return (x & 1) == 1 ? (y & 1) != 1 : (y & 1) != 0;
  }

}