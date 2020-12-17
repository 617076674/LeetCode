package question1490_clone_n_ary_tree;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：40.2MB，击败80.67%。
 */
public class Solution {

    public Node cloneTree(Node root) {
        if (null == root) {
            return null;
        }
        Node copyNode = new Node(root.val);
        for (Node child : root.children) {
            copyNode.children.add(cloneTree(child));
        }
        return copyNode;
    }

}