package question0652;

import java.util.*;

/**
 * 用前序遍历的方式序列化每颗子树，将其保存在一个map里。序列化的过程中就可以判断该子树是否重复。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：30ms，击败74.53%。消耗内存：57.4MB，击败60.55%。
 */
public class Solution {
    private Map<String, Integer> map = new HashMap<>();

    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializeTree(root);
        return result;
    }

    private String serializeTree(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String s = root.val + serializeTree(root.left) + serializeTree(root.right);
        if (map.containsKey(s)) {
            if (map.get(s) == 1) {
                result.add(root);
            }
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        return s;
    }
}