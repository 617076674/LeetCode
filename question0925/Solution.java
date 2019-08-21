package question0925;

/**
 * @author qianyihui
 * @date 2019-08-21
 *
 * 双指针。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为name的长度，n2位typed的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败56.42%。消耗内存：35MB，击败86.39%。
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n1 = name.length(), n2 = typed.length(), index = 0;
        for (int i = 0; i < n1; i++) {  //遍历name中的每一个字符
            char c = name.charAt(i);    //考虑name中的第i个字符
            //如果此时index已经等于n2，显然无法在typed找到和c对应的那个字符，因为typed已经遍历结束了
            if (index == n2) {
                return false;
            }
            //如果此时typed中第index个字符不是c
            if (typed.charAt(index) != c) {
                //如果index是0，显然就不满足，返回false
                //如果index不是0，那么该index处的字符必定需要与index - 1处的字符相同，否则，返回false
                if (index == 0 || typed.charAt(index - 1) != typed.charAt(index)) {
                    return false;
                }
                char cur = typed.charAt(index); //记typed中第index处的字符为cur
                while (index < n2 && typed.charAt(index) == cur) {  //跳过相同的字符
                    index++;
                }
                //如果index遍历到了typed数组的末尾，显然无法找到和c对应的字符，不满足，返回false
                //如果跳过相同的字符后的下一个字符不等于c，显然不满足，返回false
                if (index == n2 || typed.charAt(index) != c) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }
}
