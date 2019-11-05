package question0353_design_snake_game;

import java.util.ArrayList;
import java.util.List;

/**
 * 用一个List来保存蛇的身体。
 *
 * 执行用时：175ms，击败46.15%。消耗内存：63.8MB，击败100.00%。
 */
public class SnakeGame {
    private List<String> snakeList;

    private String head;

    private int[][] foods;

    private int index;  //当前屏幕上显示的是第index个食物

    private int width;

    private int height;

    private int score;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snakeList = new ArrayList<>();
        snakeList.add("0#0");
        head = "0#0";
        foods = new int[food.length][2];
        for (int i = 0; i < food.length; i++) {
            for (int j = 0; j < 2; j++) {
                foods[i][j] = food[i][j];
            }
        }
        this.width = width;
        this.height = height;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        String[] positions = this.head.split("#");
        int x = Integer.parseInt(positions[0]), y = Integer.parseInt(positions[1]);
        if (direction.equals("U")) {
            x--;
        } else if (direction.equals("L")) {
            y--;
        } else if (direction.equals("R")) {
            y++;
        } else {
            x++;
        }
        if (x < 0 || x >= height || y < 0 || y >= width) {  //判断是否越界
            return -1;
        }
        head = x + "#" + y;
        snakeList.add(head);    //将新头加入
        if (index < foods.length && head.equals(foods[index][0] + "#" + foods[index][1])) {
            score++;
            index++;
        } else {
            snakeList.remove(0);
        }
        if (snakeList.subList(0, snakeList.size() - 1).contains(head)) {    //判断有没有撞到身体
            return -1;
        }
        return score;
    }
}