package question099;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83374178
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    List<TreeNode> list;

    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root);
        List<Integer> wrongList = new ArrayList<>();
        int countDown = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (countDown == 0) {
                    wrongList.add(i - 1);
                    wrongList.add(i);
                }
                wrongList.set(1, i);
                countDown++;
            }
        }

        change(list, wrongList.get(0), wrongList.get(1));
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    private void change(List<TreeNode> list, int i, int j) {
        Integer temp = list.get(i).val;
        list.get(i).val = list.get(j).val;
        list.get(j).val = temp;
    }
}
