package LinkList;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rtHead = new ListNode(0);
        ListNode rtTail = rtHead;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(l1.val > l2.val ? l2.val : l1.val);
            rtTail.next = temp;
            rtTail = rtTail.next;
            if (l1.val > l2.val) {
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            rtTail.next = l1;
        }
        if (l2 != null) {
            rtTail.next = l2;
        }
        return rtHead.next;
    }
}
