package question0068_text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/text-justification/
 *
 * 时间复杂度是O(n)，其中n为words数组中的字符个数。空间复杂度是O(n / maxWidth)。
 *
 * 执行用时：1ms，击败85.27%。消耗内存：41.3MB，击败5.32%。
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int n;
        if (null == words || (n = words.length) == 0) {
            return list;
        }
        int index = 0;  //index represents which position in array words we are traversing now
        while (index < n) {
            int len = words[index].length(), i = index + 1; //every String in list contains 1 word or more
            for (; i < words.length; i++) {
                if (len + words[i].length() + 1 > maxWidth) {
                    break;
                }
                len += words[i].length() + 1;
            }
            int levelLen = 0;   //levelLen represents how many characters that isn't space in erery String
            for (int j = index; j < i; j++) {
                levelLen += words[j].length();
            }
            int numSpace = i - index - 1;   //numSpace represents how many space between 2 words
            StringBuilder sb = new StringBuilder();
            if (i != words.length) {
                if (numSpace != 0) {    //if we haven't traversed all the words
                    //if this String has more than one word
                    int[] spaces = new int[numSpace];
                    int averageSpace = (maxWidth - levelLen) / numSpace, remainSpace = maxWidth - levelLen - numSpace * averageSpace;
                    for (int j = 0; j < numSpace; j++) {
                        spaces[j] = averageSpace;
                        if (j + 1 <= remainSpace) {
                            spaces[j]++;
                        }
                    }
                    for (int j = index, k = 0; j < i && k < numSpace; j++, k++) {
                        sb.append(words[j]);
                        for (int num = 0; num < spaces[k]; num++) {
                            sb.append(" ");
                        }
                    }
                }
                sb.append(words[i - 1]);
                if (numSpace == 0) {
                    while (sb.length() < maxWidth) {    //if this String only has one word, fill space in the remain position
                        sb.append(" ");
                    }
                }
            } else {    //if we have traversed all the words, the last String we need to put all words on the left
                for (int j = index; j < i - 1; j++) {
                    sb.append(words[j] + " ");
                }
                sb.append(words[i - 1]);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            list.add(sb.toString());
            index = i;
        }
        return list;
    }
}