package contest_12_26.question3;

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

  public static void main(String[] args) {
    System.out.println(new Solution().maximumBinaryString("000110"));
    System.out.println(new Solution().maximumBinaryString("01"));
    System.out.println(new Solution().maximumBinaryString("000"));
    System.out.println(new Solution().maximumBinaryString("001"));
    System.out.println(new Solution().maximumBinaryString("010"));
  }
}