package question117;

public class Solution2 {

    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }
        TreeLinkNode first = root;
        while (null != first) {
            TreeLinkNode p = first;
            TreeLinkNode cur = null;
            first = null;
            while (null != p) {
                if (null != p.left) {
                    if (null != cur) {
                        cur.next = p.left;
                        cur = cur.next;
                    } else {
                        cur = p.left;
                        first = p.left;
                    }
                }
                if (null != p.right) {
                    if (null != cur) {
                        cur.next = p.right;
                        cur = cur.next;
                    } else {
                        cur = p.right;
                        first = p.right;
                    }
                }
                p = p.next;
            }
        }
    }
}
