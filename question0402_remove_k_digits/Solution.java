package question0402_remove_k_digits;

import java.util.Stack;

/**
 * 贪心算法。
 *
 * 对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小，例如，对于 A = 1axxx，B = 1bxxx，如果 a > b 则 A > B。
 *
 * 对于删除一个数字：给定一个数字序列[D1, D2, D3, ..., Dn]，如果D2小于D1，那么删除D1，以获得最小结果。
 *
 * 对于删除k个数字就是进行k次上述运算。
 *
 * 进行上述运算后，整个序列[A1, A2, A3, ..., Am]是一个非递减序列，则依次删除末尾元素即可。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串num的长度。
 *
 * 执行用时：19ms，击败39.55%。消耗内存：45MB，击败5.02%。
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.add(c);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}