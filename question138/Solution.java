package question138;

import java.util.HashMap;

public class Solution {
    private HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null == head){
            return null;
        }
        RandomListNode cur = head;
        while(null != cur){
            hashMap.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while(null != cur){
            hashMap.get(cur).next = hashMap.get(cur.next);
            //hashMap.get(cur).next = cur.next; 不能这样写，这样写会导致其next指针指向原节点而不是新节点
            hashMap.get(cur).random = hashMap.get(cur.random);
            //hashMap.get(cur).random = cur.random; 同理，这里也不能这样写
            cur = cur.next;
        }
        return hashMap.get(head);
    }
}
