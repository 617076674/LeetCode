package question0099;

import java.util.ArrayList;
import java.util.List;

/**
 * 先中序遍历得到中序遍历序列list，直接遍历list寻找待交换的两个节点，寻找方法如下：
 *
 * （1）以示例1为例：其中序遍历序列为[3, 2, 1]，其正确结果应为[1, 2, 3]，我们需要交换1和3的位置。
 *     3 -> 2这是一个下降沿，2 -> 1也是一个下降沿，我们记录第一个下降沿的第一个位置，和第二个下降沿的第二个位置，交换这两个位置即可。
 * （2）以示例2为例：其中序遍历序列为[1, 3, 2, 4]，其正确结果应为[1, 2, 3, 4]，我们需要交换2和3的位置。
 *     3 -> 2，这是唯一一个下降沿，我们只需交换2和3的位置即可。
 *
 *  题给的示例其实对应了两种情况——示例1对应待交换的两个节点不相邻的情况，示例2对应待交换的两个节点相邻的情况。
 *
 *  我们的解题过程也只需参考示例1和示例2即可。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：16ms，击败21.66%。消耗内存：41.3MB，击败88.62%。
 */
public class Solution2 {
    private List<TreeNode> list = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        List<Integer> wrongList = new ArrayList<>();
        int countDown = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                //如果是第一个下降沿，则记录下降沿的第一个节点和第二个节点
                if (countDown == 0) {
                    wrongList.add(i - 1);
                    wrongList.add(i);
                }
                //不管是不是第一个下降沿，我们都重置下降沿的第二个节点的值（实际上如果是第一个下降沿，没必要重置第二个节点的值）
                wrongList.set(1, i);
                countDown++;
            }
        }
        swap(list, wrongList.get(0), wrongList.get(1));
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root);
        inorderTraversal(root.right);
    }

    private void swap(List<TreeNode> list, int i, int j) {
        Integer temp = list.get(i).val;
        list.get(i).val = list.get(j).val;
        list.get(j).val = temp;
    }
}
