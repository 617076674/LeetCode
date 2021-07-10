package question0736_parse_lisp_expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private List<Map<String, Integer>> scope = new ArrayList<>();

  public Solution() {
    scope.add(new HashMap<>());
  }

  public int evaluate(String expression) {
    scope.add(new HashMap<>());
    int ans = evaluateInner(expression);
    scope.remove(scope.size() - 1);
    return ans;
  }

  private int evaluateInner(String expression) {
    if (expression.charAt(0) != '(') {
      if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
        return Integer.parseInt(expression);
      }
      for (int i = scope.size() - 1; i >= 0; i--) {
        if (scope.get(i).containsKey(expression)) {
          return scope.get(i).get(expression);
        }
      }
    }
    List<String> tokens = parse(expression.substring(
        expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
    if (expression.startsWith("add", 1)) {
      return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
    }
    if (expression.startsWith("mult", 1)) {
      return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
    }
    for (int j = 1; j < tokens.size(); j += 2) {
      scope.get(scope.size() - 1).put(tokens.get(j - 1), evaluate(tokens.get(j)));
    }
    return evaluate(tokens.get(tokens.size() - 1));
  }

  public List<String> parse(String expression) {
    List<String> result = new ArrayList<>();
    int bal = 0;
    StringBuilder sb = new StringBuilder();
    for (String token : expression.split(" ")) {
      for (char c : token.toCharArray()) {
        if (c == '(') {
          bal++;
        }
        if (c == ')') {
          bal--;
        }
      }
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(token);
      if (bal == 0) {
        result.add(new String(sb));
        sb = new StringBuilder();
      }
    }
    if (sb.length() > 0) {
      result.add(new String(sb));
    }
    return result;
  }

}