package question1363_largest_multiple_of_three;

import java.util.Arrays;

/**
 * 当一个数各个位上的数字和能被3整除时，该数能被3整除。
 *
 * 记sum为数组digits数组中的数字之和。
 *
 * （1）如果sum能被3整除，那么digits中的所有数字都可以加进结果中。
 *
 * （2）如果sum不能被3整除
 *
 * a：如果sum % 3 == 1
 *
 * 尝试移除掉digits中的某一个数digits[i]，digits[i] % 3 == 1，使得sum - digits[i]能够被3整除，
 *
 * 那么就将除去digits[i]的所有数字都加进结果中。
 *
 * 如果没有找到一个数使得digits[i] % 3 == 1，那么尝试移除掉digits中的某两个数digits[i]和digits[j]，
 *
 * (digits[i] + digits[j]) % 3 == 1，使得sum - digits[i] - digits[j]能够被3整除，
 *
 * 那么就将除去digits[i]和digits[j]的所有数字都加进结果中。
 *
 * 如果在digits中找不到一个数满足digits[i] % 3 == 1，也无法找到两个数满足(digits[i] + digits[j]) % 3 == 1，
 *
 * 有两种情况，第一种是digits数组中的所有数字除3都余0（这不可能，因为sum不能被3整除），第二种是digits数组中有且仅有一个数字除3余2，
 *
 * 其余数字除3均余0，那么显然digits数组无法找到3个、4个甚至更多个数都无法使得其和除3余1。
 *
 * b：如果sum % 3 == 2
 *
 * 尝试移除掉digits中的某一个数digits[i]，digits[i] % 3 == 2，使得sum - digits[i]能够被3整除，
 *
 * 那么就将除去digits[i]的所有数字都加进结果中。
 *
 * 如果没有找到一个数使得digits[i] % 3 == 2，那么尝试移除掉digits中的某两个数digits[i]和digits[j]，
 *
 * (digits[i] + digits[j]) % 3 == 2，使得sum - digits[i] - digits[j]能够被3整除，
 *
 * 那么就将除去digits[i]和digits[j]的所有数字都加进结果中。
 *
 * 如果在digits中找不到一个数满足digits[i] % 3 == 2，也无法找到两个数满足(digits[i] + digits[j]) % 3 == 2，
 *
 * 有两种情况，第一种是digits数组中的所有数字除3都余0（这不可能，因为sum不能被3整除），第二种是digits数组中有且仅有一个数字除3余1，
 *
 * 其余数字除3均余0，那么显然digits数组无法找到3个、4个甚至更多个数都无法使得其和除3余2。
 *
 * 时间复杂度是O(n ^ 2)，其中n是digits数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：10ms，击败100.00%。消耗内存：41.7MB，击败100.00%。
 */
public class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);    //digits数组从小到大排序
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        //移除掉0个数
        if (sum % 3 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
            while (sb.length() > 0 && sb.charAt(0) == '0') {    //去掉前置0
                sb.deleteCharAt(0);
            }
            if (sb.length() == 0) {
                return "0";
            }
            return sb.toString();
        }
        //移除掉1个数
        if (digits.length == 1) {
            return "";
        }
        for (int i = 0; i < digits.length; i++) {
            if ((sum - digits[i]) % 3 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = digits.length - 1; j >= 0; j--) {
                    if (j != i) {
                        sb.append(digits[j]);
                    }
                }
                while (sb.length() > 0 && sb.charAt(0) == '0') {    //去掉前置0
                    sb.deleteCharAt(0);
                }
                if (sb.length() == 0) {
                    return "0";
                }
                return sb.toString();
            }
        }
        if (digits.length == 2) {
            return "";
        }
        //移除掉2个数
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if ((sum - digits[i] - digits[j]) % 3 == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = digits.length - 1; k >= 0; k--) {
                        if (k != i && k != j) {
                            sb.append(digits[k]);
                        }
                    }
                    while (sb.length() > 0 && sb.charAt(0) == '0') {    //去掉前置0
                        sb.deleteCharAt(0);
                    }
                    if (sb.length() == 0) {
                        return "0";
                    }
                    return sb.toString();
                }
            }
        }
        return "";
    }
}