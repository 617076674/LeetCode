package question1366_rank_teams_by_votes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 时间复杂度和空间复杂度是O(n)，其中n为votes中的字母个数。
 *
 * 执行用时：6ms，击败100.00%。消耗内存：41.2MB，击败100.00%。
 */
public class Solution {
    public String rankTeams(String[] votes) {
        if (null == votes || votes.length == 0) {
            return "";
        }
        int[][] rank = new int[26][votes[0].length()]; //rank[i][j] 表示队伍i排名j的次数
        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                rank[s.charAt(i) - 'A'][i]++;
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < votes[0].length(); i++) {
            list.add(votes[0].charAt(i));
        }
        Collections.sort(list, (c1, c2) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (rank[c1 - 'A'][i] != rank[c2 - 'A'][i]) {
                    return rank[c2 - 'A'][i] - rank[c1 - 'A'][i];
                }
            }
            return c1 - c2;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}