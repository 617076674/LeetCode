package question0590;

import java.util.*;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 迭代实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：14ms，击败6.89%。消耗内存：59MB，击败23.83%。
 */
public class Solution2 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.peek();
            if(cur.children.size() == 0 || pre == cur.children.get(cur.children.size() - 1)){
                result.add(cur.val);
                pre = cur;
                stack.pop();
            }else{
                for(int i = cur.children.size() - 1; i >= 0; i--){
                    stack.push(cur.children.get(i));
                }
            }
        }
        return result;
    }
}
