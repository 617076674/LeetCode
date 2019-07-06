package question0179;

import java.util.Arrays;
/**
 * @author qianyihui
 * @date 2019-07-06
 *
 * 自定义比较规则，贪心算法。
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 贪心算法的证明如下：反证法。
 *
 * 我们把n个数按我们定义的排序规则排序之后，表示为A1 A2 A3 ... An。假设这样拼接出来的数字并不是最大的，
 * 即至少存在两个x和y（0 < x < y < n），交换第x个数和第y个数后，A1 A2 ... Ay ... Ax ... An > A1 A2 ... Ax ... Ay ... An。
 *
 * 由于A1 A2 ... Ax ... Ay ... An是按照我们定义的规则排好的序列，所以有Ax > Ax+1 > Ax+2 > ... > Ay-2 > Ay-1 > Ay。
 *
 * 由于Ay-1 > Ay，所以Ay-1 Ay > Ay Ay-1。我们在序列A1 A2 ... Ax ... Ay-1 Ay ... An中交换Ay-1和Ay，有
 * A1 A2 ... Ax ... Ay-1 Ay ... An > A1 A2 ... Ax ... Ay Ay-1 ... An。我们就这样一直把Ay和前面的数字交换，直到和Ax交换为止。
 * 于是即有A1 A2 ... Ax ... Ay-1 Ay ... An > A1 A2 ... Ax ... Ay Ay-1 ... An > ... > A1 A2 ... Ay Ax ... Ay-2 Ay-1 ... An
 *
 * 同理，由于Ax > Ax+1，所以Ax Ax+1 > Ax+1 Ax，于是就有
 * A1 A2 ... Ay Ax Ax+1 ... Ay-2 Ay-1 ... An > A1 A2 ... Ay Ax+1 Ax ... Ay-2 Ay-1 ... An > ... >
 * A1 A2 ... Ay Ax+1 Ax+2 ... Ay-2 Ay-1 Ax ... An。
 *
 * 所以A1 A2 ... Ay ... Ax ... An < A1 A2 ... Ax ... Ay ... An，与假设相矛盾。
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * 时间复杂度是O(nlogn)，其中n为nums数组的长度。
 *
 * 执行用时：74ms，击败24.32%。消耗内存：39.3MB，击败75.35%。
 */
public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
        }
        if (result.charAt(0) == '0') {
            return "0"; //防止出现"00"这样的结果
        }
        return result.toString();
    }
}
