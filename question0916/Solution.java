package question0916;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-24
 *
 * 时间复杂度是O(m + n)，其中m为数组A的长度，n为数组B的长度。空间复杂度是O(m)。
 *
 * 执行用时：66ms，击败55.66%。消耗内存：71.1MB，击败35.48%。
 */
public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        //bmax数组是关键
        int[] bmax = new int[26];
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; i++) {
                bmax[i] = Math.max(bmax[i], bCount[i]);
            }
        }
        List<String> result = new ArrayList();
        for (String a : A) {
            int[] aCount = count(a);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] < bmax[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(a);
            }
        }
        return result;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
