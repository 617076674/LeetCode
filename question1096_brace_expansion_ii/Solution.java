package question1096_brace_expansion_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<String> braceExpansionII(String expression) {
    expression = "{" + expression + "}";
    Queue<String> queue = new LinkedList<>();
    queue.add(expression);

    Set<String> res = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      // 拿到需要处理的表达式
      String exp = queue.poll();

      // 如果表达式中没有 {，则将这个表达式加入结果中
      if (exp.indexOf("{") == -1) {
        res.add(exp);
        continue;
      }
      // 找到表达式中第一对 {}
      int i = 0;
      int left = 0;
      int right = 0;
      while (exp.charAt(i) != '}') {
        if (exp.charAt(i) == '{') {
          left = i;
        }
        i++;
      }
      right = i;

      // 拿到第一对括号中的前面部分 (不包括 {)
      String before = exp.substring(0, left);
      // 拿到第一对括号中的后面部分 (不包括 })
      String after = exp.substring(right + 1);
      // 按照 , 分割第一对括号中的元素 (不包括 {})
      String[] strs = exp.substring(left + 1, right).split(",");

      // 将 before 、 strs 中的每个元素以及 after 拼接成字符串放入到队列中，方便后面处理
      for (String str : strs) {
        sb.setLength(0);
        queue.add(sb.append(before).append(str).append(after).toString());
      }
    }
    // 结果处理
    List<String> ans = new ArrayList<>(res);
    Collections.sort(ans);
    return ans;
  }

}