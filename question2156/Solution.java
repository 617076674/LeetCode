package question2156;

public class Solution {

  public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    long[] pows = new long[k + 1];
    pows[0] = 1;
    for (int i = 1; i < pows.length; i++) {
      pows[i] = pows[i - 1] * power % modulo;
      pows[i] %= modulo;
    }
    int resultIdx = -1;
    long temp = 0;
    for (int i = s.length() - 1; i >= s.length() - k; i--) {
      temp = temp * power;
      temp %= modulo;
      temp += s.charAt(i) - 'a' + 1;
      temp %= modulo;
    }
    if (temp == hashValue) {
      resultIdx = s.length() - k;
    }
    for (int i = s.length() - k - 1; i >= 0; i--) {
      temp -= (s.charAt(i + k) - 'a' + 1) * pows[k - 1];
      temp %= modulo;
      temp = (temp + modulo) % modulo;
      temp *= power;
      temp %= modulo;
      temp += s.charAt(i) - 'a' + 1;
      temp %= modulo;
      if (temp == hashValue) {
        resultIdx = i;
      }
    }
    return s.substring(resultIdx, resultIdx + k);
  }

}