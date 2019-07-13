package question1104;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 假想一个数组来保存树中的节点值，和堆的思路很像，但一些区域需要反转。
 *
 * 时间复杂度和空间复杂度均是O(log(label))。
 *
 * 执行用时：2ms，击败46.00%。消耗内存：34.1MB，击败100.00%。
 */
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        //求出label所在数组中的索引index
        int index = findIndexThroughNum(label);
        //利用栈来保存从label到根节点的索引路径
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (index > 1) {
            index /= 2;
            stack.push(index);
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(findNumThroughIndex(stack.pop()));
        }
        return result;
    }

    /**
     * 通过数组索引来获取数字
     */
    private int findNumThroughIndex(int index) {
        int exponent = findExponent(index);
        if (exponent % 2 == 0) {
            return index;
        }
        return ((int) Math.pow(2, exponent + 1)) - 1 - index + ((int) Math.pow(2, exponent));
    }

    /**
     * 通过数字来获取数组索引
     */
    private int findIndexThroughNum(int num) {
        int exponent = findExponent(num);
        if (exponent % 2 == 0) {
            return num;
        }
        return ((int) Math.pow(2, exponent + 1)) - 1 - num + ((int) Math.pow(2, exponent));
    }

    /**
     * 寻找到一个数exponent，使其满足：2 ^ exponent <= digit < 2 ^ (exponent + 1)
     */
    private int findExponent(int digit) {
        int result = 0;
        while (digit > 0) {
            digit /= 2;
            result++;
        }
        return result - 1;
    }
}