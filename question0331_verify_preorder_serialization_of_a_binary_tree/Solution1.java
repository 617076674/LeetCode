package question0331_verify_preorder_serialization_of_a_binary_tree;

import java.util.LinkedList;

/**
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是字符串preorder的长度。
 *
 * 执行用时：16ms，击败13.29%。消耗内存：36.3MB，击败67.65%。
 */
public class Solution1 {

  public boolean isValidSerialization(String preorder) {
    int n = preorder.length();
    if (n == 0) {
      return true;
    }
    String[] strings = preorder.split(",");
    LinkedList<String> stack = new LinkedList<>();
    for (String string : strings) {
      stack.addLast(string);
      while (stack.size() >= 3 && "#".equals(stack.peekLast()) && "#".equals(stack.get(stack.size() - 2))) {
        stack.removeLast();
        stack.removeLast();
        ///如果根节点为空，返回false
        if ("#".equals(stack.peekLast())) {
          return false;
        }
        stack.pollLast();
        stack.addLast("#");    //这一步很关键：发现一颗完整的树后需要压入栈中一个“#”
      }
    }
    return stack.size() == 1 && "#".equals(stack.peekLast());
  }

}