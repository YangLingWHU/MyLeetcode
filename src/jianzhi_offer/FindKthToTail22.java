package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 */
public class FindKthToTail22 {
    // 面试题22 p134 找到链表的倒数第k个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 1) {
            p2 = p2.next;
            k--;
            if (p2 == null) { // 说明链表长度<k
                return null;
            }
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
