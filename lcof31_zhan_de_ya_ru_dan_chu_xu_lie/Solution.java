package lcof31_zhan_de_ya_ru_dan_chu_xu_lie;

import java.util.LinkedList;

public class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    LinkedList<Integer> stack = new LinkedList<>();
    int index = 0;
    for (int push : pushed) {
      stack.push(push);
      while (!stack.isEmpty() && stack.peek() == popped[index]) {
        stack.pop();
        index++;
      }
    }
    return stack.isEmpty();
  }

}