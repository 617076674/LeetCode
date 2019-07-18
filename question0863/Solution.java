package question0863;

import java.util.*;

/**
 * @author qianyihui
 * @date 2019-07-18
 *
 * 首先在以target为根节点的子树中寻找。
 *
 * 然后在target的父节点中寻找，比如，假设target的父节点是parent，target是parent的左孩子，那就去parent的右孩子查找。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：6ms，击败54.29%。消耗内存：36.5MB，击败51.11%。
 */
public class Solution {
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        result.addAll(distanceK(target, K));
        List<TreeNode> parents = getParents(root, target);
        for (int i = parents.size() - 1; i > 0; i--) {
            TreeNode cur1 = parents.get(i), cur2 = parents.get(i - 1);
            if (i < K) {
                if (cur2 == cur1.left) {
                    result.addAll(distanceK(cur1.right, K - i - 1));
                } else {
                    result.addAll(distanceK(cur1.left, K - i - 1));
                }
            } else if (i == K) {
                result.add(cur1.val);
            }
        }
        return result;
    }

    /**
     * 获取从root到target路径上的所有节点，将其父节点信息存储在parentMap里
     */
    private List<TreeNode> getParents(TreeNode root, TreeNode target) {
        List<TreeNode> list = new ArrayList<>();
        if (root == target) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                    parentMap.put(treeNode.left, treeNode);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                    parentMap.put(treeNode.right, treeNode);
                }
                if (parentMap.containsKey(target)) {
                    TreeNode cur = target;
                    list.add(target);
                    while (parentMap.containsKey(cur)) {
                        list.add(parentMap.get(cur));
                        cur = parentMap.get(cur);
                    }
                    return list;
                }
            }
        }
        return list;
    }

    /**
     * 在以root为根节点的子树中搜索距离为K的节点
     */
    private List<Integer> distanceK(TreeNode root, int K) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (K == 0) {
                    list.add(treeNode.val);
                }
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
            K--;
        }
        return list;
    }
}
