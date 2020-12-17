package question1586_binary_search_tree_iterator_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：96ms，击败96.43%。消耗内存：65.3MB，击败39.29%。
 */
public class BSTIterator {

    private List<Integer> inOrder = new ArrayList<>();

    private int index = -1;

    public BSTIterator(TreeNode root) {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        inOrder.add(treeNode.val);
        inOrderTraversal(treeNode.right);
    }
    
    public boolean hasNext() {
        return index < inOrder.size() - 1;
    }
    
    public int next() {
        return inOrder.get(++index);
    }
    
    public boolean hasPrev() {
        return index > 0;
    }
    
    public int prev() {
        return inOrder.get(--index);
    }

}