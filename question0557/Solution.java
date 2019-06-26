package question0557;

/**
 * @author qianyihui
 * @date 2019-06-23
 * <p>
 * 执行用时：30ms，击败31.40%。消耗内存：49.3MB，击败52.55%。
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                stringBuilder.append(temp.reverse());
                stringBuilder.append(c);
                temp = new StringBuilder();
            } else {
                temp.append(c);
            }
        }
        stringBuilder.append(temp.reverse());
        return stringBuilder.toString();
    }
}
