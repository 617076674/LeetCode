package question190;

public class Solution1 {
    public int reverseBits(int n) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(n)).reverse();
        while (stringBuilder.length() < 32) {
            stringBuilder.append("0");
        }
        if ('0' == stringBuilder.charAt(0)) {
            return Integer.parseInt(stringBuilder.toString(), 2);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if ('0' == stringBuilder.charAt(i)) {
                stringBuilder.setCharAt(i, '1');
            } else {
                stringBuilder.setCharAt(i, '0');
            }
        }
        return -1 - Integer.parseInt(stringBuilder.toString(), 2);
    }
}
