package question0752_open_the_lock;

import java.util.*;

/**
 * 双向广搜。
 *
 * 执行用时：39ms，击败93.92%。消耗内存：40.4MB，击败33.33%。
 */
public class Solution2 {
    private Set<String> visited = new HashSet<>(), deadSet = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        Set<String> set1 = new HashSet<>();
        set1.add(begin);
        Set<String> set2 = new HashSet<>();
        set2.add(target);
        deadSet.addAll(Arrays.asList(deadends));
        if (deadSet.contains(begin) || deadSet.contains(target)) {
            return -1;
        }
        int result = 0;
        while (!set1.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> tmp = set1;
                set1 = set2;
                set2 = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String s : set1) {
                if (set2.contains(s)) {
                    return result;
                }
                visited.add(s);
                List<String> next = getNext(s);
                for (String nextString : next) {
                    tmp.add(nextString);
                }
            }
            set1 = tmp;
            result++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        List<String> result = new ArrayList<>();
        int[] directions = new int[] {-1, 1};
        for (int i = 0; i < s.length(); i++) {
            for (int direction : directions) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(s.charAt(j));
                }
                sb.append((s.charAt(i) - '0' + direction + 10) % 10);
                for (int j = i + 1; j < s.length(); j++) {
                    sb.append(s.charAt(j));
                }
                String tmp = sb.toString();
                if (!deadSet.contains(tmp) && !visited.contains(tmp)) {
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}