package question0158_read_n_characters_given_read4_ii_call_multiple_times;

public class Solution extends Reader4 {

  private char[] buf4 = new char[4];

  private int begin, size;

  public int read(char[] buf, int n) {
    if (begin + n - 1 <= size - 1) {
      // 仅需要从 buf4 中读取即可
      for (int i = 0; i < n; i++) {
        buf[i] = buf4[begin + i];
      }
      begin = begin + n;
      return n;
    }
    // 先从 buf4 中读取
    int index = 0;
    for (int i = begin; i < size; i++) {
      buf[index++] = buf4[i];
    }
    while (true) {
      int cnt = read4(buf4);
      if (cnt == 0) {
        size = 0;
        begin = 0;
        return index;
      }
      for (int i = 0; i < cnt; i++) {
        buf[index++] = buf4[i];
        if (index == n) {
          begin = i + 1;
          size = cnt;
          return n;
        }
      }
    }
  }

}