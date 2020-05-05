package question0752_open_the_lock;

import java.util.*;

/**
 * 广搜。
 *
 * 执行用时：165ms，击败49.21%。消耗内存：47.8MB，击败11.11%。
 */
public class Solution1 {
    private Set<String> visited = new HashSet<>(), deadSet = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        visited.add(begin);
        deadSet.addAll(Arrays.asList(deadends));
        if (deadSet.contains(begin) || deadSet.contains(target)) {
            return -1;
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String now = queue.poll();
                if (now.equals(target)) {
                    return result;
                }
                List<String> next = getNext(now);
                for (String s : next) {
                    queue.add(s);
                    visited.add(s);
                }
            }
            result++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        List<String> result = new ArrayList<>();
        int[] directions = new int[]{-1, 1};
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