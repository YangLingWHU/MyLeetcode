package LinkList;

import java.util.List;

public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode i = vHead;
        ListNode j = head;
        ListNode k = j.next;
        while (j != null && k != null) {
            ListNode temp = k.next;
            i.next = k;
            j.next = temp;
            k.next = j;

            i = j;
            j = temp;
            if (j != null) {
                k = temp.next;
            }
        }
        return vHead.next;
    }
}
