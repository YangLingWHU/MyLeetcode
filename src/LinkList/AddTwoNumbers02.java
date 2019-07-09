package LinkList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rtHead = new ListNode(0);
        ListNode rtTail = rtHead;
        rtHead.next = null;

        int tempSum = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            tempSum = l1.val + l2.val + carry;
            carry = tempSum / 10;
            ListNode rtTemp = new ListNode(tempSum % 10);
            rtTail.next = rtTemp;
            rtTail = rtTail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tempSum = l1.val + carry;
            carry = tempSum / 10;
            ListNode rtTemp = new ListNode(tempSum % 10);
            rtTail.next = rtTemp;
            rtTail = rtTail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tempSum = l2.val + carry;
            carry = tempSum / 10;
            ListNode rtTemp = new ListNode(tempSum % 10);
            rtTail.next = rtTemp;
            rtTail = rtTail.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode rtTemp = new ListNode(1);
            rtTail.next = rtTemp;
            rtTail = rtTail.next;
        }
        return rtHead.next;
    }
}
