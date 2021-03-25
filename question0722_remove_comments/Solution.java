package question0722_remove_comments;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> removeComments(String[] source) {
    List<String> result = new ArrayList<>();
    boolean inBlock = false;
    StringBuilder sb = new StringBuilder();
    for (String line : source) {
      if (!inBlock) {
        sb = new StringBuilder();
      }
      for (int i = 0; i < line.length(); i++) {
        if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
          inBlock = true;
          i++;
        } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
          inBlock = false;
          i++;
        } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
          break;
        } else if (!inBlock) {
          sb.append(line.charAt(i));
        }
      }
      if (!inBlock && sb.length() > 0) {
        result.add(sb.toString());
      }
    }
    return result;
  }

}