package question1206_design_skiplist;

import java.util.Stack;

/**
 * 跳表。
 */
public class Skiplist {

    private static class SkipNode {
        int val;
        SkipNode right, down;

        public SkipNode(int val, SkipNode right, SkipNode down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }

    private SkipNode head = new SkipNode(-1, null, null);
    
    public boolean search(int target) {
        SkipNode cur = head;
        while (cur != null) {
            while (cur.right != null && cur.right.val < target) {
                cur = cur.right;
            }
            if (cur.right != null && cur.right.val == target) {
                return true;
            }
            cur = cur.down;
        }
        return false;
    }
    
    public void add(int num) {
        Stack<SkipNode> stack = new Stack<>();
        SkipNode cur = head;
        while (cur != null) {
            while (cur.right != null && cur.right.val < num) {
                cur = cur.right;
            }
            stack.push(cur);
            cur = cur.down;
        }
        boolean insert = true;
        SkipNode down = null;
        while (insert && !stack.isEmpty()) {
            SkipNode node = stack.pop();
            node.right = new SkipNode(num, node.right, down);
            down = node.right;
            insert = Math.random() < 0.5;
        }
        if (insert) {
            head = new SkipNode(-1, null, head);
        }
    }
    
    public boolean erase(int num) {
        SkipNode cur = head;
        boolean found = false;
        while (cur != null) {
            while (cur.right != null && cur.right.val < num) {
                cur = cur.right;
            }
            if (cur.right != null && cur.right.val == num) {
                cur.right = cur.right.right;
                found = true;
            }
            cur = cur.down;
        }
        return found;
    }

}