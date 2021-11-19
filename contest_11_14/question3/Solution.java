package contest_11_14.question3;

public class Solution {

  public String decodeCiphertext(String encodedText, int rows) {
    char[][] graph = new char[rows][encodedText.length() / rows];
    int index = 0;
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        graph[i][j] = encodedText.charAt(index++);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int gap = 0; gap >= 1 - graph[0].length; gap--) {
      for (int i = 0; i < rows && i - gap < graph[0].length; i++) {
        int x = i, y = i - gap;
        sb.append(graph[x][y]);
      }
    }
    while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String encodedText = " b  ac";
    System.out.println(new Solution().decodeCiphertext(encodedText, 2));
  }

}