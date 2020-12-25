package lcof33_er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie;

public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int k = -1;
        for (int i = left; i < right; i++) {
            if (postorder[i] > postorder[right]) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            return verifyPostorder(postorder, left, right - 1);
        }
        for (int i = k; i < right; i++) {
            if (postorder[i] < postorder[right]) {
                return false;
            }
        }
        return verifyPostorder(postorder, left, k - 1) && verifyPostorder(postorder, k, right - 1);
    }

}