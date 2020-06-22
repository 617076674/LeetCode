package lcci1618_pattern_matching;

/**
 * 根据字符 a 和 b 代表的子串的长度进行穷举。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：37.8MB，击败100.00%。
 */
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }
        int nA = 0, nB = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                nA++;
            } else {
                nB++;
            }
        }
        if (nA < nB) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'a') {
                    sb.append('b');
                } else {
                    sb.append('a');
                }
            }
            return patternMatching(sb.toString(), value);
        }
        if (value.length() == 0) {
            return nB == 0;
        }
        for (int lenA = 0; lenA * nA <= value.length(); lenA++) {
            int remain = value.length() - lenA * nA;
            if ((nB == 0 && remain == 0) || (nB != 0 && remain % nB == 0)) {
                int lenB = nB == 0 ? 0 : remain / nB, index1 = 0, index2 = 0;
                String aString = null, bString = null;
                for (; index1 < pattern.length(); index1++) {
                    if (pattern.charAt(index1) == 'a') {
                        if (null == aString) {
                            aString = value.substring(index2, index2 + lenA);
                        } else if (!aString.equals(value.substring(index2, index2 + lenA))) {
                            break;
                        }
                        index2 += lenA;
                    } else {
                        if (null == bString) {
                            bString = value.substring(index2, index2 + lenB);
                        } else if (!bString.equals(value.substring(index2, index2 + lenB))) {
                            break;
                        }
                        index2 += lenB;
                    }
                }
                if (index1 == pattern.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}