package question145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    private class TagNode {
        TreeNode treeNode;
        boolean visited;
        public TagNode(TreeNode treeNode) {
            this.treeNode = treeNode;
            this.visited = false;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TagNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(new TagNode(cur));
                cur = cur.left;
            }
            TagNode tagNode = stack.pop();
            cur = tagNode.treeNode;
            if(tagNode.visited) {
                list.add(tagNode.treeNode.val);
                cur = null;
            }else {
                tagNode.visited = true;
                stack.push(tagNode);
                cur = cur.right;
            }
        }
        return list;
    }
}

