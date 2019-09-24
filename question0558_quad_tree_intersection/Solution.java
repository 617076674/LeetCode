package question0558_quad_tree_intersection;

/**
 * 递归。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为网格数。
 *
 * 执行用时：1ms，击败98.54%。消耗内存：41.5MB，击败91.67%。
 */
public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        if (quadTree1.isLeaf && !quadTree2.isLeaf) {
            if (quadTree1.val) {
                return new Node(true, true, null, null, null, null);
            }
            Node node = new Node();
            node.isLeaf = false;
            node.topLeft = intersect(quadTree1, quadTree2.topLeft);
            node.topRight = intersect(quadTree1, quadTree2.topRight);
            node.bottomLeft = intersect(quadTree1, quadTree2.bottomLeft);
            node.bottomRight = intersect(quadTree1, quadTree2.bottomRight);
            if (canMerge(node)) {
                return new Node(node.topLeft.val, true, null, null, null, null);
            }
            return node;
        }
        if (!quadTree1.isLeaf && quadTree2.isLeaf) {
            return intersect(quadTree2, quadTree1);
        }
        Node node = new Node();
        node.isLeaf = false;
        node.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        node.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        node.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (canMerge(node)) {
            return new Node(node.topLeft.val, true, null, null, null, null);
        }
        return node;
    }

    private boolean canMerge(Node node) {
        return node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf &&
                node.topLeft.val == node.topRight.val && node.topRight.val == node.bottomLeft.val &&
                node.bottomLeft.val == node.bottomRight.val;
    }
}
