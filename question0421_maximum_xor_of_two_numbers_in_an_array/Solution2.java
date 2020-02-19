package question0421_maximum_xor_of_two_numbers_in_an_array;

/**
 * 前缀树。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：12ms，击败98.80%。消耗内存：57.1MB，击败5.59%。
 */
public class Solution2 {
    private class TrieNode {
        private int val;

        private TrieNode zero, one;

        private boolean isNum;
    }

    private class TrieTree {
        private TrieNode root = new TrieNode();

        public void insert(int num) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0 && cur.zero == null) {
                    cur.zero = new TrieNode();
                }
                if (bit == 1 && cur.one == null) {
                    cur.one = new TrieNode();
                }
                cur = bit == 0 ? cur.zero : cur.one;
            }
            cur.val = num;
            cur.isNum = true;
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        TrieTree root = new TrieTree();
        for (int n : nums) {
            root.insert(n);
        }
        //获取真正需要开始判断的root
        //以题目所给示例[3, 10, 5, 25, 2, 8]说明，各个数字的二进制表示如下：
        //3： 0000 0000 0000 0000 0000 0000 0000 0011
        //10：0000 0000 0000 0000 0000 0000 0000 1010
        //5： 0000 0000 0000 0000 0000 0000 0000 0101
        //25：0000 0000 0000 0000 0000 0000 0001 1001
        //2： 0000 0000 0000 0000 0000 0000 0000 0010
        //8： 0000 0000 0000 0000 0000 0000 0000 1000
        //显然对于[5, 31]位的元素，其值均为0，无需进行判断计算，因此真正的根节点就是第5位的元素，其值为0，其子节点值有两个，分别是0和1
        TrieNode cur = root.root;
        while (null == cur.one || null == cur.zero) {
            cur = cur.zero != null ? cur.zero : cur.one;
        }
        return findMaximumXOR(cur.one, cur.zero);
    }

    private int findMaximumXOR(TrieNode one, TrieNode zero) {
        if (one.isNum && zero.isNum) {  //如果均递归到底，两个节点代表的均是数字
            return one.val ^ zero.val;
        }
        if (one.zero == null) { //如果节点one的子节点只能取1，那么节点zero的子节点应尽可能取0
            return findMaximumXOR(one.one, zero.zero == null ? zero.one : zero.zero);
        } else if (one.one == null) {   //如果节点one的子节点只能取0，那么节点zero的子节点应尽可能取1
            return findMaximumXOR(one.zero, zero.one == null ? zero.zero : zero.one);
        } else if (zero.zero == null) { //如果节点zero的子节点只能取1，那么节点one的子节点取0
            return findMaximumXOR(one.zero, zero.one);
        } else if (zero.one == null) {  //如果节点zero的子节点只能取0，那么节点one的子节点取1
            return findMaximumXOR(one.one, zero.zero);
        }
        //进入此处说明节点one和节点zero均存在两个子节点分别是0和1
        return Math.max(findMaximumXOR(one.one, zero.zero), findMaximumXOR(one.zero, zero.one));
    }
}