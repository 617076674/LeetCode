package question0917_reverse_only_letters;

/**
 * 时间复杂度是O(n)，其中n为字符串S的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败96.71%。消耗内存：34.4MB，击败92.97%。
 */
public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int index1 = 0, index2 = S.length() - 1;
        while (index1 < index2) {
            while (!isLetter(chars[index1])) {
                index1++;
                if (index1 >= S.length()) { //需要加越界处理
                    break;
                }
            }
            while (!isLetter(chars[index2])) {
                index2--;
                if (index2 < 0) {   //需要加越界处理
                    break;
                }
            }
            if (index1 >= index2) {
                break;
            }
            swap(chars, index1, index2);
            index1++;
            index2--;
        }
        return String.valueOf(chars);
    }

    private boolean isLetter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
