package question0657_robot_return_to_origin;

/**
 * 要能移动到原点，U和D出现的次数、L和R出现的次数均要相同才行。
 *
 * 时间复杂度是O(n)，其中n为字符串moves的长度。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败72.76%。消耗内存：38.2MB，击败95.21%。
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    count1++;
                    break;
                case 'D':
                    count1--;
                    break;
                case 'L':
                    count2++;
                    break;
                case 'R':
                    count2--;
            }
        }
        return count1 == 0 && count2 == 0;
    }
}