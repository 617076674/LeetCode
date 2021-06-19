package question0937_reorder_data_in_log_files;

import java.util.Arrays;

public class Solution {

  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (log1, log2) -> {//运用到了java里的泛型，第二个参数重新定义排序规则
      String[] split1 = log1.split(" ", 2); //将log1 按分隔符“ ” ，分成2份，即把标识符分开来
      String[] split2 = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//判断除标识符外的第一个字符是数字true，字母false
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
      if (!isDigit1 && !isDigit2) { //如果两个日志都是字母日志
        int cmp = split1[1].compareTo(split2[1]); //先比较内容字母split1>split2则返回1，等于返0，小于返-1
        if (cmp != 0) {
          return cmp;
        }
        return split1[0].compareTo(split2[0]);//若内容字母相同则比较标识符
      }
      return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
      //如果split1是数字字符，且split2是数字字符返回0，
      // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
      // 如果split1是字母字符，返回-1，
    });
    return logs;
  }

}