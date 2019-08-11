package question0556;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-08-11
 *
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：2ms，击败33.61%。消耗内存：33.5MB，击败44.44%。
 */
public class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);
        int i = list.size() - 1;
        for (; i > 0; i--) {
            if (list.get(i) > list.get(i - 1)) {    //从后往前看，寻找到第一个下降沿
                break;
            }
        }
        if (i == 0) {   //从后往前看，没有下降沿，不存在更大的排列
            return -1;
        }
        int min = i;    //寻找[i, list.size() - 1]范围内比list.get(i - 1)更大的最小值所在的索引
        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(j) > list.get(i - 1) && list.get(j) < list.get(min)) {
                min = j;
            }
        }
        Collections.swap(list, min, i - 1); //交换i - 1和min上的数字
        long result = 0;
        for (int j = 0; j < i; j++) {
            result = result * 10 + list.get(0);
            list.remove(0);
        }
        Collections.sort(list); //对剩余部分按升序排列
        for (int j = 0; j < list.size(); j++) {
            result = result * 10 + list.get(j);
        }
        if (result > Integer.MAX_VALUE) {   //考虑数据越界问题
            return -1;
        }
        return (int) result;
    }
}
