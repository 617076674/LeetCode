package question116;

public class Solution3 {
    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }
        TreeLinkNode first = root;
        while(null != first) {
            TreeLinkNode p = first;
            TreeLinkNode cur = null;
            first = p.left;
            while (null != p) {
                if(null != cur) {
                    cur.next = p.left;
                    cur = cur.next;
                }else{
                    cur = p.left;
                }
                if(null != cur) {
                    cur.next = p.right;
                    cur = cur.next;
                }
                p = p.next;
            }
        }
    }
}

