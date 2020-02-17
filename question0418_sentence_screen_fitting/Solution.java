package question0418_sentence_screen_fitting;

/**
 * https://leetcode-cn.com/problems/sentence-screen-fitting/
 *
 * 时间复杂度是O(m + rows)，其中m是sentence数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：17ms，击败75.96%。消耗内存：40.6MB，击败6.45%。
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String s : sentence) {
            sb.append(s).append(" ");
        }
        int index = 0, len = sb.length();   //(index % len)指针指向的是sb中的某个字符
        for (int i = 0; i < rows; i++) {
            index += cols;  //一行可以包含cols个字符
            if (sb.charAt(index % len) == ' ') {    //(index % len)指针指向的字符是空格
                //此时该行最末单元填充的恰好是某一单词的最后一个字符，下一个单词会从下一行行首开始填充，而无需再添加空格
                //从另一个角度来看，相对于该空格被忽略了，即无需填充该空格
                index++;
            } else {    //(index % len)指针指向的字符不是空格
                //此时该行无法完整填充当前单词，当前单词会从下一行行首开始填充
                //需要回退index指针的位置直到(index - 1 % len)指针指向的字符是空格
                while (index > 0 && sb.charAt((index - 1) % len) != ' ') {
                    index--;
                }
            }
        }
        return index / len;
    }
}