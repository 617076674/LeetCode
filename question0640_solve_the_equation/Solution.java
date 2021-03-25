package question0640_solve_the_equation;

public class Solution {

  public String coeff(String x) {
    if (x.length() > 1 && Character.isDigit(x.charAt(x.length() - 2))) {
      return x.replace("x", "");
    }
    return x.replace("x", "1");
  }

  public String solveEquation(String equation) {
    String[] lr = equation.split("=");
    int lhs = 0, rhs = 0;
    for (String x : lr[0].split("(?=\\+)|(?=-)")) {
      if (x.contains("x")) {
        lhs += Integer.parseInt(coeff(x));
      } else {
        rhs -= Integer.parseInt(x);
      }
    }
    for (String x : lr[1].split("(?=\\+)|(?=-)")) {
      if (x.contains("x")) {
        lhs -= Integer.parseInt(coeff(x));
      } else {
        rhs += Integer.parseInt(x);
      }
    }
    if (lhs == 0) {
      return rhs == 0 ? "Infinite solutions" : "No solution";
    }
    return "x=" + rhs / lhs;
  }

}