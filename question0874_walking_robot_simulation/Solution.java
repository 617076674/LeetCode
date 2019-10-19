package question0874_walking_robot_simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 一步一步地移动，判断是否遇到了障碍物。
 *
 * 时间复杂度是O(n)，其中n为commands中的正数和。空间复杂度是O(m)，其中m为障碍物的数量。
 *
 * 执行用时：18ms，击败99.25%。消耗内存：51.8MB，击败89.76%。
 */
public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //起点是(0, 0)，flag = 0表示面向东方，flag = 1表示面向南方，flag = 2表示面向西方，flag = 3表示面向北方
        int x = 0, y = 0, flag = 3, result = 0;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] * 30000L + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                flag = (flag + 3) % 4;  //左转90度
            } else if (commands[i] == -1) {
                flag = (flag + 1) % 4;  //右转90度
            } else {
                if (flag == 0) {
                    for (int j = 0; j < commands[i]; j++) { //一步步地移动，判断是否遇到障碍物
                        x++;
                        if (set.contains(x * 30000L + y)) {
                            x--;
                            break;
                        }
                    }
                } else if (flag == 1) {
                    for (int j = 0; j < commands[i]; j++) {
                        y--;
                        if (set.contains(x * 30000L + y)) {
                            y++;
                            break;
                        }
                    }
                } else if (flag == 2) {
                    for (int j = 0; j < commands[i]; j++) {
                        x--;
                        if (set.contains(x * 30000L + y)) {
                            x++;
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < commands[i]; j++) {
                        y++;
                        if (set.contains(x * 30000L + y)) {
                            y--;
                            break;
                        }
                    }
                }
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}
