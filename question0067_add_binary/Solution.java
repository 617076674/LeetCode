package question0067_add_binary;

/**
 * 时间复杂度是O(max(na, nb))，其中na是字符串a的长度，nb是字符串b的长度。
 *
 * 执行用时：2ms，击败98.52%。消耗内存：38.5MB，击败7.69%。
 */
public class Solution {
    private int flag;

    public String addBinary(String a, String b) {
        int nA = a.length(), nB = b.length(), indexA = nA - 1, indexB = nB - 1;
        StringBuilder result = new StringBuilder();
        while (indexA >= 0 && indexB >= 0) {
            int num = a.charAt(indexA) - '0' + b.charAt(indexB) - '0' + flag;
            if (num >= 2) {
                num -= 2;
                flag = 1;
            } else {
                flag = 0;
            }
            result.append(num);
            indexA--;
            indexB--;
        }
        if (indexA != -1) {
            append(a, indexA, result);
        } else if (indexB != -1) {
            append(b, indexB, result);
        }
        return flag == 1 ? result.append(1).reverse().toString() : result.reverse().toString();
    }

    private void append(String s, int index, StringBuilder sb) {
        while (index >= 0) {
            int num = s.charAt(index) - '0' + flag;
            if (num >= 2) {
                num -= 2;
                flag = 1;
            } else {
                flag = 0;
            }
            sb.append(num);
            index--;
        }
    }
}