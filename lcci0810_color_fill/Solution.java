package lcci0810_color_fill;

public class Solution {

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    dfs(image, sr, sc);
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        if (image[i][j] < 0) {
          image[i][j] = newColor;
        }
      }
    }
    return image;
  }

  private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private void dfs(int[][] image, int row, int col) {
    int origin = image[row][col];
    image[row][col] = -1;
    for (int[] direction : directions) {
      int nextRow = direction[0] + row, nextCol = direction[1] + col;
      if (nextRow >= 0 && nextRow < image.length && nextCol >= 0 && nextCol < image[0].length && image[nextRow][nextCol] == origin) {
        dfs(image, nextRow, nextCol);
      }
    }
  }

}