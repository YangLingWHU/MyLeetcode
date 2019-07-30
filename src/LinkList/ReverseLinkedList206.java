package LinkList;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        // 头插法
        ListNode rtHead = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = rtHead.next;
            rtHead.next = head;
            head = temp;
        }
        return rtHead.next;
    }
}

