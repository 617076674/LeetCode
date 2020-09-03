package question0459_repeated_substring_pattern;

/**
 * 如果s可以由它的一个子串重复多次构成。
 * 假设s可以由2个子串A组成，即AA，那么s+s由4个A组成，即AAAA。当我们破坏首尾的子串A时，中间的两个A依然可以组成字符串s。
 * 假设s可以由3个子串A组成，即AAA，同上。
 * 假设s可以由4个子串A组成，即AAAA，同上。
 * ……
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：61ms，击败63.93%。消耗内存：37.6MB，击败96.30%。
 */
public class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}