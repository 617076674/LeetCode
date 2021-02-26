package question1358_number_of_substrings_containing_all_three_characters;

public class Solution2 {

    public int numberOfSubstrings(String s) {
        int indexA = -1, indexB = -1, indexC = -1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    indexA = i;
                    break;
                case 'b':
                    indexB = i;
                    break;
                default:
                    indexC = i;
            }
            result += Math.min(indexA, Math.min(indexB, indexC)) + 1;
        }
        return result;
    }

}