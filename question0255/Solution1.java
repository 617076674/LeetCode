package question0255;

/**
 * @author qianyihui
 * @date 2019-07-31
 *
 * 递归实现。
 *
 * 时间复杂度是O(n ^ 2)，其中n是preorder数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：410ms，击败30.77%。消耗内存：49.7MB，击败100.00%。
 */
public class Solution1 {
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int index = left + 1;
        if (preorder[index] > preorder[left]) {
            for (int i = index + 1; i <= right; i++) {
                if (preorder[i] < preorder[left]) {
                    return false;
                }
            }
            return verifyPreorder(preorder, left + 1, right);
        } else {
            while (index <= right && preorder[index] < preorder[left]) {    //防止index越界需要判断index <= right
                index++;
            }
            for (int i = index + 1; i <= right; i++) {
                if (preorder[i] < preorder[left]) {
                    return false;
                }
            }
            return verifyPreorder(preorder, left + 1, index - 1) && verifyPreorder(preorder, index, right);
        }
    }
}
