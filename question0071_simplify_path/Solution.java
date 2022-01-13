package question0071_simplify_path;

import java.util.LinkedList;

public class Solution {

  private static final char FILE_SEPARATOR = '/';

  public String simplifyPath(String path) {
    LinkedList<String> linkedList = new LinkedList<>();
    for (int i = 0; i < path.length(); ) {
      while (i < path.length() && path.charAt(i) == FILE_SEPARATOR) {
        i++;
      }
      StringBuilder sb = new StringBuilder();
      while (i < path.length() && path.charAt(i) != FILE_SEPARATOR) {
        sb.append(path.charAt(i));
        i++;
      }
      if (sb.length() == 0) {
        continue;
      }
      if (".".equals(sb.toString())) {

      } else if ("..".equals(sb.toString())) {
        if (!linkedList.isEmpty()) {
          linkedList.removeLast();
        }
      } else {
        linkedList.addLast(sb.toString());
      }
    }
    if (linkedList.isEmpty()) {
      return "" + FILE_SEPARATOR;
    }
    StringBuilder result = new StringBuilder();
    while (!linkedList.isEmpty()) {
      result.append(FILE_SEPARATOR).append(linkedList.removeFirst());
    }
    return result.toString();
  }

}