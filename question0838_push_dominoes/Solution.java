package question0838_push_dominoes;

public class Solution {
  public String pushDominoes(String dominoes) {
    char[] chars = new char[dominoes.length()];
    for (int i = 0; i < dominoes.length(); i++) {
      chars[i] = dominoes.charAt(i);
    }
    int preR = -1, preL = -1;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'R') {
        if (preR > preL) {
          for (int j = preR + 1; j < i; j++) {
            chars[j] = 'R';
          }
        }
        preR = i;
      } else if (chars[i] == 'L') {
        if (preR <= preL) {
          for (int j = preL + 1; j < i; j++) {
            chars[j] = 'L';
          }
        } else {
          int index1 = preR + 1, index2 = i - 1;
          while (index1 < index2) {
            chars[index1] = 'R';
            chars[index2] = 'L';
            index1++;
            index2--;
          }
        }
        preL = i;
      }
    }
    if (preR > preL) {
      for (int i = preR + 1; i < chars.length; i++) {
        chars[i] = 'R';
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }
}