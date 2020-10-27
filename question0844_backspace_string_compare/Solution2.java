package question0844_backspace_string_compare;

/**
 * 从后往前遍历字符串。
 *
 * 时间复杂度是是O(max(n1, n2))，其中n1为字符串S的长度，n2为字符串T的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败96.17%。消耗内存：34.9MB，击败77.78%。
 */
public class Solution2 {

    public boolean backspaceCompare(String S, String T) {
        return transform(S).equals(transform(T));
    }

    private String transform(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;  //记录需要删除的字符数
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                count++;    //需要删除的字符数加1
            } else {
                if (count > 0) {
                    count--;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}