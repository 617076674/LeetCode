package question0942;

import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-06-29
 *
 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；如果下一个弹出的数字不再栈顶，则把压栈序列中还没有
 * 入栈的数字压入辅助栈，直到找到下一个需要弹出的数字；如果所有数字都压入了辅助栈却没有找到下一个需要弹
 * 出的数字，那么该序列就不可能是一个弹出序列。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为压栈序列的长度。
 *
 * 执行用时：6ms，击败88.81%。消耗内存：38.9MB，击败84.88%。
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n1 = pushed.length, n2 = popped.length, index1 = 0, index2 = 0;
        if (n1 != n2) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        while (index2 < n2) {
            if (!stack.isEmpty() && stack.peek() == popped[index2]) {
                stack.pop();
                index2++;
            } else {
                int i = index1;
                boolean flag = false;
                for (; i < n1; i++) {
                    if (pushed[i] == popped[index2]) {
                        index1 = i + 1;
                        flag = true;
                        break;
                    } else {
                        stack.push(pushed[i]);
                    }
                }
                if (!flag) {
                    return false;
                }
                index2++;
            }
        }
        return true;
    }
}
