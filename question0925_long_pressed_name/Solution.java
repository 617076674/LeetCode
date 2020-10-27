package question0925_long_pressed_name;

/**
 * 双指针。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为name的长度，n2位typed的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败56.42%。消耗内存：35MB，击败86.39%。
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0, index2 = 0;
        while (index2 < typed.length()) {
            if (index1 < name.length() && name.charAt(index1) == typed.charAt(index2)) {
                index1++;
                index2++;
            } else if (index2 > 0 && typed.charAt(index2 - 1) == typed.charAt(index2)) {
                index2++;
            } else {
                return false;
            }
        }
        return index1 == name.length();
    }

}