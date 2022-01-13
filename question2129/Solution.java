package question2129;

public class Solution {

  public String capitalizeTitle(String title) {
    StringBuilder sb = new StringBuilder();
    String[] words = title.split(" ");
    for (String word : words) {
      if (sb.length() > 0) {
        sb.append(" ");
      }
      if (word.length() <= 2) {
        sb.append(word.toLowerCase());
      } else {
        sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
      }
    }
    return sb.toString();
  }

}