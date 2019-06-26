package question099;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83374178
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1 {

    List<TreeNode> list;

    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root);
        List<TreeNode> tempList = new ArrayList<>(list);
        Collections.sort(tempList, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode treeNode1, TreeNode treeNode2) {
                return treeNode1.val - treeNode2.val;
            }
        });
        List<Integer> wrongList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val != tempList.get(i).val) {
                wrongList.add(i);
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
