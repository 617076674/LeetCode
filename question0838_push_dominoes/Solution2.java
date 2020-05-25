package question0838_push_dominoes;

/**
 * 找 L 和 R 所在的索引，分别对一个个区间进行处理。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 dominoes 的长度。
 *
 * 执行用时：11ms，击败63.21%。消耗内存：40.4MB，击败28.57%。
 */
public class Solution2 {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int pre = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                if (pre == -1 || dominoes.charAt(pre) == 'L') {
                    for (int j = pre + 1; j <= i; j++) {
                        sb.append('L');
                    }
                } else if (dominoes.charAt(pre) == 'R') {
                    for (int j = pre + 1; j < pre + (i - pre + 1) / 2; j++) {
                        sb.append('R');
                    }
                    if (((i - pre) & 1) == 0) {
                        sb.append('.');
                    }
                    for (int j = pre + 1 + (i - pre) / 2; j <= i; j++) {
                        sb.append('L');
                    }
                }
                pre = i;
            } else if (c == 'R') {
                if (pre == -1) {
                    sb.append(dominoes, 0, i + 1);
                } else if (dominoes.charAt(pre) == 'L') {
                    for (int j = pre + 1; j < i; j++) {
                        sb.append('.');
                    }
                    sb.append('R');
                } else if (dominoes.charAt(pre) == 'R') {
                    for (int j = pre + 1; j <= i; j++) {
                        sb.append('R');
                    }
                }
                pre = i;
            }
        }
        if (pre == -1) {
            return dominoes;
        }
        if (dominoes.charAt(pre) == 'R') {
            for (int i = pre + 1; i < dominoes.length(); i++) {
                sb.append('R');
            }
        } else if (dominoes.charAt(pre) == 'L') {
            sb.append(dominoes.substring(pre + 1));
        }
        return sb.toString();
    }
}