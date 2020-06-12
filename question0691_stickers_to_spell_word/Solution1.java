package question0691_stickers_to_spell_word;

/**
 * 深搜。
 *
 * https://leetcode.com/problems/stickers-to-spell-word/solution/
 *
 * 执行用时：14ms，击败97.98%。消耗内存：38.3MB，击败25.00%。
 */
public class Solution1 {
    private int result = Integer.MAX_VALUE;

    private int[][] stickersMap;

    private int[] targetMap;

    public int minStickers(String[] stickers, String target) {
        int[] nativeTargetMap = new int[26];
        for (int i = 0; i < target.length(); i++) {
            nativeTargetMap[target.charAt(i) - 'a']++;
        }
        int[] indexes = new int[26];
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (nativeTargetMap[i] > 0) {
                indexes[i] = index++;
            } else {
                indexes[i] = -1;
            }
        }
        targetMap = new int[index];
        index = 0;
        for (int num : nativeTargetMap) {
            if (num > 0) {
                targetMap[index++] = num;
            }
        }
        stickersMap = new int[stickers.length][index];
        for (int i = 0; i < stickers.length; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                char c = stickers[i].charAt(j);
                if (indexes[c - 'a'] >= 0) {
                    stickersMap[i][indexes[c - 'a']]++;
                }
            }
        }
        int anchor = 0; //[0, anchor)内的stickers[i]是已经被包含的值
        for (int i = 0; i < stickers.length; i++) {
            for (int j = anchor; j < stickers.length; j++) {
                if (j != i) {
                    boolean dominated = true;
                    for (int k = 0; k < index; k++) {
                        if (stickersMap[i][k] > stickersMap[j][k]) {
                            dominated = false;
                            break;
                        }
                    }
                    if (dominated) {
                        int[] tmp = stickersMap[i];
                        stickersMap[i] = stickersMap[anchor];
                        stickersMap[anchor++] = tmp;
                        break;
                    }
                }
            }
        }
        minStickers(0, anchor);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void minStickers(int len, int anchor) {
        if (len >= result) {
            return;
        }
        if (anchor == stickersMap.length) {
            for (int c : targetMap) {
                if (c > 0) {
                    return;
                }
            }
            result = len;
            return;
        }
        int used = 0;
        for (int i = 0; i < stickersMap[anchor].length; i++) {
            if (targetMap[i] > 0 && stickersMap[anchor][i] > 0) {
                used = Math.max(used, (targetMap[i] - 1) / stickersMap[anchor][i] + 1);
            }
        }
        for (int i = 0; i < stickersMap[anchor].length; i++) {
            targetMap[i] -= used * stickersMap[anchor][i];
        }
        minStickers(len + used, anchor + 1);
        while (used > 0) {
            for (int i = 0; i < stickersMap[anchor].length; i++) {
                targetMap[i] += stickersMap[anchor][i];
            }
            used--;
            minStickers(len + used, anchor + 1);
        }
    }
}