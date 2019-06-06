package question501;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution1 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        preOrderTraversal(root);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer integer = (Integer) iterator.next();
            if (map.get(integer) != maxCount) {
                iterator.remove();
            }
        }
        int[] result = new int[map.size()];
        int i = 0;
        for (Integer integer : map.keySet()) {
            result[i] = integer;
            i++;
        }
        return result;
    }

    private void preOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        int val = treeNode.val;
        if (map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
            maxCount = Math.max(maxCount, map.get(val));
        } else {
            map.put(val, 1);
            maxCount = Math.max(maxCount, 1);
        }
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

}
