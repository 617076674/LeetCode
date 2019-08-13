package question0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 先将原数组根据子数组第一个元素进行降序排序，得到一个身高从高到矮的列表。
 * 从头开始遍历，以子数组的第二个元素作为索引插入到列表中相应位置（插队），直到遍历完成，则队列重建完毕。
 *
 * 时间复杂度是O(nlogn)，其中n为people数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：76ms，击败33.98%。消耗内存：58.4MB，击败8.18%
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
