package question0038_count_and_say;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82620708
 *
 * 递归实现。
 *
 * 执行用时：2ms，击败92.33%。消耗内存：33.9MB，击败94.70%。
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < pre.length(); ) {
            int index = 1;
            for (int i = k; i < pre.length() - 1; i++) {
                if (pre.charAt(i) == pre.charAt(i + 1)) {
                    index++;
                } else {
                    break;
                }
            }
            sb.append(index);
            sb.append(pre.charAt(k));
            k += index;
        }
        return sb.toString();
    }
}