package question109;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(null != cur){
            list.add(cur.val);
            cur = cur.next;
        }
        return sortedArrayToBST(list);
    }

    private TreeNode sortedArrayToBST(List<Integer> list) {
        TreeNode treeNode = null;
        if(list.size() == 0) {
            return treeNode;
        }
        int mid = list.size() / 2;
        treeNode = new TreeNode(list.get(mid));
        List<Integer> leftNums = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftNums.add(list.get(i));
        }
        List<Integer> rightNums = new ArrayList<>();
        for (int i = mid + 1; i < list.size(); i++) {
            rightNums.add(list.get(i));
        }
        treeNode.left = sortedArrayToBST(leftNums);
        treeNode.right = sortedArrayToBST(rightNums);
        return treeNode;
    }
}