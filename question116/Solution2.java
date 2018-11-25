package question116;

public class Solution2 {

    public void connect(TreeLinkNode root) {
        if(null == root){
            return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode cur = pre.left;
        int level = 0;
        while(null != cur){
            if(cur == pre.left){
                cur.next = pre.right;
                cur = cur.next;
            }else{
                if(cur == pre.right && null != pre.next){
                    cur.next = pre.next.left;
                    cur = cur.next;
                    pre = pre.next;
                }else{
                    pre = root;
                    level++;
                    for(int i = 0; i < level; i++){
                        pre = pre.left;
                    }
                    cur = pre.left;
                }
            }
        }
    }
}
