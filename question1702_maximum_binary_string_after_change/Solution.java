package question1702_maximum_binary_string_after_change;

public class Solution {

  public String maximumBinaryString(String binary) {
    int count0 = 0;
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '0') {
        count0++;
      }
    }
    if (count0 <= 1) {
      return binary;
    }
    int count1 = 0;
    for (int i = binary.indexOf('0') + 1; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        count1++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < binary.length(); i++) {
      sb.append('1');
    }
    sb.setCharAt(binary.length() - count1 - 1, '0');
    return sb.toString();
  }

}