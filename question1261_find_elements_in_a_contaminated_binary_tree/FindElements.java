package question1261_find_elements_in_a_contaminated_binary_tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：28ms，击败91.55%。消耗内存：43.4MB，击败53.89%。
 */
public class FindElements {

    private Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        if (null == root) {
            return;
        }
        root.val = 0;
        set.add(0);
        FindElementsHelper(root);
    }

    private void FindElementsHelper(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        if (treeNode.left != null) {
            treeNode.left.val = 2 * treeNode.val + 1;
            set.add(treeNode.left.val);
        }
        if (treeNode.right != null) {
            treeNode.right.val = 2 * treeNode.val + 2;
            set.add(treeNode.right.val);
        }
        FindElementsHelper(treeNode.left);
        FindElementsHelper(treeNode.right);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

}