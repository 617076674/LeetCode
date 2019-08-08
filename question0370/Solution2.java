package question0370;

import java.util.Arrays;

/**
 * @author qianyihui
 * @date 2019-08-08
 *
 * 区间求和。
 *
 * 注意到题目的两个特点如下：
 * （1）只有一次对所有数的查询，且发生在所有更新操作之后的最后，并且每次更新操作都是互不相关的。
 * （2）累积和以及部分和操作只对操作区间内的数字有影响，对其他数字没有影响。
 *
 * 这个算法利用以上想法，只在操作区间的边界上存储变化的值（而不是整个区间都进行更新）。最终只需要对整个数组求一遍和。
 *
 * 算法步骤如下：
 * （1）对每一个更新操作 (start, end, val) ，我们用一个求和数组result来记录变化值，我们做2个操作：
 *      a. 更新start，result[start] += val
 *      b. 更新end + 1，result[end + 1] -= val
 * （2）最终，求整个数组的前缀和
 *      result[i] = result[i] + result[i - 1]
 *
 * 时间复杂度是O(length + n)，其中n为updates的行数。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败66。67%。消耗内存：57.3MB，击败100.00%。
 */
public class Solution2 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length + 1]; //防止end+1越界
        for (int i = 0; i < updates.length; i++) {
            result[updates[i][0]] += updates[i][2];
            result[updates[i][1] + 1] -= updates[i][2];
        }
        int num = 0;
        for (int i = 0; i < length; i++) {
            num += result[i];
            result[i] = num;
        }
        return Arrays.copyOfRange(result, 0, length + 1);
    }
}
