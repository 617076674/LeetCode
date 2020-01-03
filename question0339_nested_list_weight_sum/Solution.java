package question0339_nested_list_weight_sum;

import java.util.List;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n是元素总数。空间复杂度是O(m)，其中m是最大嵌套层数。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.4MB，击败100.00%。
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}