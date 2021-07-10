package question0726_number_of_atoms;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

  public String countOfAtoms(String formula) {
    Stack<Object> stack = new Stack<>();
    for (int i = 0; i < formula.length(); i++) {
      char c = formula.charAt(i);
      if (Character.isUpperCase(c)) {
        int j = i;
        while (j + 1 < formula.length() && Character.isLowerCase(formula.charAt(j + 1))) {
          j++;
        }
        String s = formula.substring(i, j + 1);
        int count = 0;
        while (j + 1 < formula.length() && Character.isDigit(formula.charAt(j + 1))) {
          count = count * 10 + formula.charAt(j + 1) - '0';
          j++;
        }
        if (count == 0) {
          count = 1;
        }
        if (stack.isEmpty()) {
          Map<String, Integer> map = new TreeMap<>();
          map.put(s, count);
          stack.add(map);
        } else {
          Object object = stack.peek();
          if (object instanceof Character) {
            Map<String, Integer> map = new TreeMap<>();
            map.put(s, count);
            stack.add(map);
          } else {
            Map<String, Integer> map = (Map<String, Integer>) object;
            map.put(s, map.getOrDefault(s, 0) + count);
          }
        }
        i = j;
      } else if (c == '(') {
        stack.add(c);
      } else if (c == ')') {
        int j = i;
        int count = 0;
        while (j + 1 < formula.length() && Character.isDigit(formula.charAt(j + 1))) {
          count = count * 10 + formula.charAt(j + 1) - '0';
          j++;
        }
        if (count == 0) {
          count = 1;
        }
        i = j;
        Map<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty() && !(stack.peek() instanceof Character)) {
          Map<String, Integer> temp = (Map<String, Integer>) stack.pop();
          for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + count * entry.getValue());
          }
        }
        stack.pop();
        stack.add(map);
      }
    }
    Map<String, Integer> map = new TreeMap<>();
    while (!stack.isEmpty()) {
      for (Map.Entry<String, Integer> entry : ((Map<String, Integer>) stack.pop()).entrySet()) {
        map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey());
      if (entry.getValue() != 1) {
        sb.append(entry.getValue());
      }
    }
    return sb.toString();
  }

}