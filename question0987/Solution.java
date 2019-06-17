package question0987;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * 首先建立一个TreeMap<Integer, TreeMap<Integer, List<Integer>>>类型的变量treeMap，层次比较多，需搞清楚各个分层的依据。
 *
 * 首先根据x分，再根据y分，x与y均相同的点后期通过Collections工具类提供的排序函数排序。
 *
 * 递归地遍历整颗二叉树，将节点根据x与y分类填充进treeMap中。遍历过程既可以中序遍历也可以前序遍历，也可以后序遍历，甚至可以层序遍历。
 *
 * 由于有对x与y均相同的点的排序操作，时间复杂度和树的结构有关，但一定高于O(n)，其中n为树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败93.88%。内存消耗：35.5MB，击败95.65%。
 */
public class Solution {

    private TreeMap<Integer, TreeMap<Integer, List<Integer>>> treeMap = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preOrderTraversal(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> temp : treeMap.values()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> tempList : temp.values()) {
                Collections.sort(tempList);
                list.addAll(tempList);
            }
            result.add(list);
        }
        return result;
    }

    private void preOrderTraversal(TreeNode treeNode, int x, int y) {
        if (null == treeNode) {
            return;
        }
        if (null == treeMap.get(x)) {
            treeMap.put(x, new TreeMap<>());
            treeMap.get(x).put(y, new ArrayList<>());
            treeMap.get(x).get(y).add(treeNode.val);
        } else {
            if (null == treeMap.get(x).get(y)) {
                treeMap.get(x).put(y, new ArrayList<>());
                treeMap.get(x).get(y).add(treeNode.val);
            } else {
                treeMap.get(x).get(y).add(treeNode.val);
            }
        }
        if (null != treeNode.left) {
            preOrderTraversal(treeNode.left, x - 1, y + 1);
        }
        if (null != treeNode.right) {
            preOrderTraversal(treeNode.right, x + 1, y + 1);
        }
    }

}