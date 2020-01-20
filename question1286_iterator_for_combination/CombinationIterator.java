package question1286_iterator_for_combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是O(2 ^ n)，其中n是字符串characters的长度。空间复杂度是O(n)。
 *
 * 执行用时：8ms，击败96.89%。消耗内存：38.9MB，击败100.00%。
 */
public class CombinationIterator {
    private List<String> list;

    private int index;

    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        dfs(new StringBuilder(), 0, characters, combinationLength);
    }
    
    public String next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index != list.size();
    }

    private void dfs(StringBuilder sb, int index, String characters, int combinationLength) {
        if (sb.length() == combinationLength) {
            list.add(sb.toString());
            return;
        }
        if (index == characters.length()) {
            return;
        }
        sb.append(characters.charAt(index));
        dfs(sb, index + 1, characters, combinationLength);
        sb.deleteCharAt(sb.length() - 1);
        dfs(sb, index + 1, characters, combinationLength);
    }
}