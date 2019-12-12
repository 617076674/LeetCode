package question0271_encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 在编码的时候在每个字符串前记录其长度，并用一分隔符分开。
 *
 * 执行用时：7ms，击败87.76%。消耗内存：39MB，击败100.00%。
 */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append(",").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int pos = s.indexOf(',', i), itemSize = Integer.parseInt(s.substring(i, pos)), start = pos + 1,
                    end = pos + itemSize + 1;
            if (end <= s.length()) {
                result.add(s.substring(start, end));
            }
            i = end;
        }
        return result;
    }
}