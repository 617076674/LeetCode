package question061;

public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    // ����n��Ԫ�ص�����arr����һ������
    // ʹ��arrΪ��������������һ��ListNode�Ĺ��캯��
    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    // �����Ե�ǰListNodeΪͷ����������Ϣ�ַ���
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("");
        ListNode curNode = this;
        while (curNode != null) {
            s.append(Integer.toString(curNode.val));
            s.append(" -> ");
            curNode = curNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
