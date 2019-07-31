package question0255;

import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-07-31
 *
 * （1）先序遍历，如果递减，一定是左子树。
 * （2）如果出现非递减的值，意味着到了某个节点的右子树。
 * （3）利用栈来寻找该节点，最后一个比当前元素小的从栈弹出的元素即为该节点的父亲节点，而且当前元素父节点即为新的下限值。
 * （3）后续的元素一定是比当前的下限值要大的，否则return false；
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是preorder数组的长度。
 *
 * 执行用时：60ms，击败35.9%。消耗内存：49.7MB，击败100.00%。
 */
public class Solution2 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                min = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}
