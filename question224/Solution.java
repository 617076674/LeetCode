package question224;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            Character temp = s.charAt(i);
            if(temp >= '0' && temp <= '9'){
                int[] result = findNextNumAndIndex(s, i);
                stringBuilder.append(result[0]);
                stringBuilder.append(" ");
                i = result[1];
            }else if(temp == '('){
                stack.push(temp);
                i++;
            }else if(temp == '+' || temp == '-'){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty()){
                        Character item = stack.pop();
                        if(item == '('){
                            stack.push(item);
                            break;
                        }else{
                            stringBuilder.append(item);
                            stringBuilder.append(" ");
                        }
                    }
                }
                stack.push(temp);
                i++;
            }else if(temp == ')'){
                Character item = stack.pop();
                while(item != '('){
                    stringBuilder.append(item);
                    stringBuilder.append(" ");
                    item = stack.pop();
                }
                i++;
            }else{
                i++;
            }
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }
        String[] strings = stringBuilder.toString().split(" ");
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].charAt(0) == '+'){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num2 + num1);
            }else if(strings[i].charAt(0) == '-'){
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                numStack.push(num2 - num1);
            }else{
                numStack.push(Integer.parseInt(strings[i]));
            }
        }
        return numStack.pop();
    }
    private int[] findNextNumAndIndex(String s, int index){
        int num = 0;
        int i = index;
        for (; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = num * 10 + s.charAt(i) - '0';
            }else{
                break;
            }
        }
        int[] result = new int[2];
        result[0] = num;
        result[1] = i;
        return result;
    }
}
