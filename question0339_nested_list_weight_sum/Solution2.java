package question0339_nested_list_weight_sum;

import question0364_nested_list_weight_sum_ii.NestedInteger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历实现。
 *
 * 时间复杂度是和空间复杂度均O(n)，其中n是元素数量。
 *
 * 执行用时：1ms，击败99.26%。消耗内存：34.5MB，击败5.00%。
 */
public class Solution2 {
    public int depthSum(List<NestedInteger> nestedList) {
        if (null == nestedList || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        int depth = 0, result = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size(), sum = 0;
            for (int i = 0; i < qSize; i++) {
                NestedInteger tmp = queue.poll();
                if (tmp.isInteger()) {
                    sum += tmp.getInteger();
                } else {
                    queue.addAll(tmp.getList());
                }
            }
            depth++;
            result += sum * depth;
        }
        return result;
    }
}