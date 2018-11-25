package question116;

import java.util.LinkedList;

public class Solution1 {

    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> linkedList = new LinkedList<>();   //linkedList[i]用来存储第i层的一个节点
        dfs(root, 0, linkedList);
    }

    private void dfs(TreeLinkNode root, int level, LinkedList<TreeLinkNode> linkedList){
        if(null == root){   //如果root为null，直接返回
            return;
        }
        if(linkedList.size() <= level){
            linkedList.add(root);
        }else{
            TreeLinkNode treeLinkNode = linkedList.get(level);
            treeLinkNode.next = root;
            linkedList.remove(level);
            linkedList.add(level, root);
        }
        dfs(root.left, level + 1, linkedList);
        dfs(root.right, level + 1, linkedList);
    }
}
