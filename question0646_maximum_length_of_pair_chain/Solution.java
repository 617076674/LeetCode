package question0646_maximum_length_of_pair_chain;

/**
 * 每次选择符合条件的且第二个数字最小的数对。
 *
 * 执行用时：10ms，击败99.40%。消耗内存：39.5MB，击败100.00%。
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        int next, result = 0;
        Integer pre = null;
        while (true) {
            next = -1;
            for (int i = 0; i < pairs.length; i++) {
                if ((pre == null || pairs[i][0] > pre) && (next == -1 || pairs[i][1] < pairs[next][1])) {
                    next = i;
                }
            }
            if (next == -1) {
                break;
            }
            result++;
            pre = pairs[next][1];
        }
        return result;
    }
}