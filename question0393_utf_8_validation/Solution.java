package question0393_utf_8_validation;

/**
 * 逐个逐个判断即可。
 *
 * 时间复杂度是O(n)，其中n为data数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：7ms，击败22.64%。消耗内存：39.3MB，击败17.71%。
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int n;
        if (null == data || (n = data.length) == 0) {
            return true;
        }
        for (int i = 0; i < n;) {
            String binaryString = Integer.toBinaryString(data[i]);
            int len = binaryString.length();
            if (len < 8 || binaryString.charAt(len - 8) == '0') {
                i++;
                continue;
            }
            String subBinaryString = binaryString.substring(len - 8);
            if (subBinaryString.startsWith("110")) {
                if (i + 1 >= n || !isPrefix10(data[i + 1])) {
                    return false;
                }
                i += 2;
            } else if (subBinaryString.startsWith("1110")) {
                if (i + 2 >= n || !isPrefix10(data[i + 1]) || !isPrefix10(data[i + 2])) {
                    return false;
                }
                i += 3;
            } else if (subBinaryString.startsWith("11110")) {
                if (i + 3 >= n || !isPrefix10(data[i + 1]) || !isPrefix10(data[i + 2]) || !isPrefix10(data[i + 3])) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isPrefix10 (int num) {
        String binaryString = Integer.toBinaryString(num);
        if (binaryString.length() < 8) {
            return false;
        }
        return binaryString.substring(binaryString.length() - 8).startsWith("10");
    }
}