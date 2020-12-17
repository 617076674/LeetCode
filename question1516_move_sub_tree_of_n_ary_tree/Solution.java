package question1516_move_sub_tree_of_n_ary_tree;

/**
 * 可以分为 2 种情况：
 * 1- q 是 p 的子树
 * （1）寻找到 q 的父节点，将 q 节点从其孩子节点列表中移除。
 * （2）寻找到 p 的父节点，将 p 节点从其孩子节点列表中移除。
 * （3）将 q 节点放进 p 节点的原父节点的孩子节点列表中。
 * （4）将 p 节点放进 q 节点的孩子节点列表中。
 * 2- q 不是 p 的子树
 * （1）寻找到 p 的父亲节点，将 p 节点从其孩子节点列表中移除。
 * （2）将 p 放进 q 的孩子节点列表中。
 *
 * 执行用时：5ms，击败100.00%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {

    private boolean isQInP;

    private Node p;

    private Node parentP;

    private Node q;

    private Node parentQ;

    public Node moveSubTree(Node root, Node p, Node q) {
        if (q.children.contains(p)) {
            return root;
        }
        this.p = p;
        this.q = q;
        dfsP(p);
        Node dummyRoot = new Node();
        dummyRoot.children.add(root);
        if (isQInP) {
            findParentP(dummyRoot, null);
            findParentQ(dummyRoot, null);
            int pIndex = parentP.children.indexOf(p);
            parentP.children.remove(pIndex);
            parentQ.children.remove(q);
            parentP.children.add(pIndex, q);
            q.children.add(p);
        } else {
            findParentP(dummyRoot, null);
            parentP.children.remove(p);
            q.children.add(p);
        }
        return dummyRoot.children.get(0);
    }

    private void findParentP(Node node, Node parent) {
        if (null == node || parentP != null) {
            return;
        }
        if (node == p) {
            parentP = parent;
        }
        for (Node child : node.children) {
            findParentP(child, node);
        }
    }

    private void findParentQ(Node node, Node parent) {
        if (null == node || parentQ != null) {
            return;
        }
        if (node == q) {
            parentQ = parent;
        }
        for (Node child : node.children) {
            findParentQ(child, node);
        }
    }

    private void dfsP(Node node) {
        if (null == node || isQInP) {
            return;
        }
        if (node == q) {
            isQInP = true;
        }
        for (Node child : node.children) {
            dfsP(child);
        }
    }

}