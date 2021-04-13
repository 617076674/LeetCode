package question0831_masking_personal_information;

public class Solution {

  public String maskPII(String S) {
    int atIndex = S.indexOf('@');
    if (atIndex >= 0) { // email
      return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();
    }
    // phone
    String digits = S.replaceAll("\\D+", "");
    String local = "***-***-" + digits.substring(digits.length() - 4);
    if (digits.length() == 10) {
      return local;
    }
    String result = "+";
    for (int i = 0; i < digits.length() - 10; ++i) {
      result += "*";
    }
    return result + "-" + local;
  }

}