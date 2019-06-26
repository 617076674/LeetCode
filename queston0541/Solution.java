package queston0541;

/**
 * @author qianyihui
 * @date 2019-06-24
 * <p>
 * 执行用时：4ms，击败57.28%。消耗内存：41.6MB，击败53.20%。
 */
public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            if (((i / k) & 1) == 1) {
                //不需要翻转
                stringBuilder.append(s, i, Math.min(i + k, n));
            } else {
                //需要翻转
                StringBuilder temp = new StringBuilder(s.substring(i, Math.min(i + k, n)));
                stringBuilder.append(temp.reverse());
            }
        }
        return stringBuilder.toString();
    }
}
