package question0282_expression_add_operators;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/expression-add-operators/solution/gei-biao-da-shi-tian-jia-yun-suan-fu-by-leetcode/
 *
 * 回溯法。
 *
 * 在回溯过程中动态地计算表达式的值，由于涉及乘法，其优先级比加法和减法要高，因此需要记录前一个操作数的值，当涉及乘法时，需要减去前一个操作
 * 数的值，然后再加上当前操作数和前一个操作数的乘积。
 *
 * 时间复杂度是O(4 ^ n)，其中n为字符串num的长度。空间复杂度是O(n)。
 *
 * 执行用时：80ms，击败87.01%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    private List<String> result = new ArrayList<>();

    private String num;

    private int target;

    public List<String> addOperators(String num, int target) {
        if (null == num || num.length() == 0) {
            return result;
        }
        this.target = target;
        this.num = num;
        addOperators(0, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void addOperators(int index, long previousOperand, long currentOperand, long value, List<String> list) {
        if (index == num.length()) {
            if (value == target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < list.size(); i++) { //第一个字符串是操作符加号，需要跳过
                    sb.append(list.get(i));
                }
                result.add(sb.toString());
            }
            return;
        }
        currentOperand = currentOperand * 10 + num.charAt(index) - '0';
        String currentValRep = String.valueOf(currentOperand);
        if (currentOperand > 0) {   //防止出现05 00的情况
            addOperators(index + 1, previousOperand, currentOperand, value, list);
        }
        list.add("+");  //第一个数前面有一个默认的被省略的加号
        list.add(currentValRep);
        addOperators(index + 1, currentOperand, 0, value + currentOperand, list);
        list.remove(list.size() - 1); //变量回溯
        list.remove(list.size() - 1); //变量回溯
        if (list.size() > 0) {  //对于一开始的操作数，是不考虑减号和乘号的
            list.add("-");
            list.add(currentValRep);
            addOperators(index + 1, -currentOperand, 0, value - currentOperand, list);
            list.remove(list.size() - 1); //变量回溯
            list.remove(list.size() - 1); //变量回溯
            list.add("*");
            list.add(currentValRep);
            addOperators(index + 1, currentOperand * previousOperand, 0, value - previousOperand + (currentOperand * previousOperand), list);
            list.remove(list.size() - 1); //变量回溯
            list.remove(list.size() - 1); //变量回溯
        }
    }
}