package question0163;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-08-04
 *
 * 设置前驱节点pre是关键，初始时将pre值设为lower - 1，注意防止int型数据越界。
 *
 * 执行用时：1ms，击败98.00%。消耗内存：34.9MB，击败100.00%。
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long pre = (long)lower - 1; // prevent 'int' overflow
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - pre == 2) {   //只差一个数的情况
                result.add(String.valueOf(pre + 1));
            } else if (nums[i] - pre > 2) { //差多个数的情况
                result.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i]; //更新前一个节点信息
        }
        //别忘记对upper还要进行判断，因为upper是最后一个节点了，所以其判断界限是和数组中最后一个元素的差值是否为1
        if (upper - pre == 1) {
            result.add(String.valueOf(pre + 1));
        } else if (upper - pre > 1) {
            result.add((pre + 1) + "->" + upper);
        }
        return result;
    }
}
