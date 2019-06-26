package question0144;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris前序遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.05%。消耗内存：35.3MB，击败40.72%。
 */
public class Solution4 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        while (cur != null) {
            //前序遍历的访问顺序是先本节点，再左节点，再右节点
            if (cur.left == null) {
                //如果说当前节点的左孩子为null，就无需考虑其左子树，直接记录当前节点的值并访问右孩子即可
                list.add(cur.val);
                cur = cur.right;
            } else {
                //prev节点的含义是：当前节点在中序遍历时的前驱节点
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                //如果prev的右孩子为null，说明是第一次访问该节点
                if (prev.right == null) {
                    //令prev的右孩子为当前节点
                    prev.right = cur;
                    //记录该节点的值
                    list.add(cur.val);
                    //访问当前节点的左孩子
                    cur = cur.left;
                //如果prev的右孩子不为null，说明是第二次访问该节点
                } else {
                    //令prev的右孩子为null
                    prev.right = null;
                    //访问当前节点的右孩子
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
