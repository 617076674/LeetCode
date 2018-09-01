package question023;

/*
 * 解析请见：https://blog.csdn.net/qq_41231926/article/details/82263333
 */
public class Solution1 {
	
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode[] curs = new ListNode[lists.length];
		for (int i = 0; i < curs.length; i++) {
			curs[i] = lists[i];
		}
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		boolean flag = true;
		do {
			int index = 0;
			for(int i = 0; i < curs.length; i++) {
				if(curs[i] != null) {
					break;
				}
				index++;
			}
			//如果输入的lists数组中没有元素，或者有元素但是每一个元素都是null，直接返回null
            if(index == curs.length) {
				return null;
			}
			ListNode minTemp = curs[index];
			for(int i = index; i < curs.length; i++) {
				if(curs[i] != null && curs[i].val < minTemp.val) {
					minTemp = curs[i];
				}
			}
			for(int i = index; i < curs.length; i++) {
				if(curs[i] != null && minTemp.val == curs[i].val) {
					curs[i] = curs[i].next;
					break;
				}
			}
			cur.next = minTemp;
			cur = cur.next;
			flag = false;
			for (int i = 0; i < curs.length; i++) {
				if(curs[i] != null) {
					flag = true;
				}
			}
		}while(flag);
		return dummyHead.next;
	}
}
