package question0466;

/**
 * 时间复杂度是O(n1 * len(s1))。空间复杂度是O(1)。
 *
 * 执行用时：1220ms，击败35.38%。消耗内存：34.5MB，击败85.71%。
 */
public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //index为遍历字符串s2中每一个字符的索引，num1为当前使用了s1的个数，num2为当前使用了s2的个数
        int index = 0, num1 = 0, num2 = 0;
        while (num1 < n1) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    if (index == s2.length() - 1) {
                        index = 0;
                        num2++;
                    } else {
                        index++;
                    }
                }
            }
            num1++;
        }
        return num2 / n2;
    }
}
