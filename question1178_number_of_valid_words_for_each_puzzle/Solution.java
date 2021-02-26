package question1178_number_of_valid_words_for_each_puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int count = 0, mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    count += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            result.add(count);
        }
        return result;
    }

}