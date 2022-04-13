package question2232;

public class Solution {

  public String minimizeResult(String expression) {
    int opIdx = expression.indexOf('+');
    String num1 = expression.substring(0, opIdx);
    String num2 = expression.substring(opIdx + 1);
    int minRes = Integer.MAX_VALUE;
    String res = null;
    for (int i = 0; i < num1.length(); i++) {
      for (int j = 0; j < num2.length(); j++) {
        int temp1 = i == 0 ? 1 : Integer.parseInt(num1.substring(0, i));
        int temp2 = Integer.parseInt(num1.substring(i));
        int temp3 = Integer.parseInt(num2.substring(0, j + 1));
        int temp4 = j == num2.length() - 1 ? 1 : Integer.parseInt(num2.substring(j + 1));
        int temp = temp1 * (temp2 + temp3) * temp4;
        if (temp < minRes) {
          minRes = temp;
          res = num1.substring(0, i) + "(" + num1.substring(i) + "+" + num2.substring(0, j + 1)
              + ")" + num2.substring(j + 1);
        }
      }
    }
    return res;
  }

}
