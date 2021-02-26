package question0989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 大数加法，注意进位。
 *
 * 时间复杂度是O(max(n, logK))，其中n是数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：9ms，击败79.43%。消耗内存：40.7MB，击败90.88%。
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int num = A[i] + K % 10 + flag;
            if (num >= 10) {
                flag = 1;
                num -= 10;
            } else {
                flag = 0;
            }
            list.add(num);
            K /= 10;
        }
        while (K != 0 || flag != 0) {
            int num = K % 10 + flag;
            if (num >= 10) {
                flag = 1;
                num -= 10;
            } else {
                flag = 0;
            }
            list.add(num);
            K /= 10;
        }
        Collections.reverse(list);
        return list;
    }

}