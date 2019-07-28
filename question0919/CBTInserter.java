package question0919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 构造函数的时间复杂度和空间复杂度均是O(n)，其中n为初始化时树中节点的数量。
 *
 * insert函数的时间复杂度和空间复杂度均是O(1)。
 *
 * get_root函数的时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：125ms，击败51.61%。消耗内存：41.3MB，击败100.00%。
 */
public class CBTInserter {

    private TreeNode root;

    private List<TreeNode> levelOrder = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                levelOrder.add(treeNode);
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
        }
    }
    
    public int insert(int v) {
        levelOrder.add(new TreeNode(v));
        int index = levelOrder.size() - 1;
        int parentIndex = parent(index);
        TreeNode father = levelOrder.get(parentIndex);
        if (parentIndex * 2 + 1 == index) {
            father.left = levelOrder.get(index);
        } else {
            father.right = levelOrder.get(index);
        }
        return father.val;
    }

    private int parent(int i) {
        return (i - 1) >> 1;
    }
    
    public TreeNode get_root() {
        return root;
    }
}