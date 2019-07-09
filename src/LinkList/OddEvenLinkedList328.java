package LinkList;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList328 {

    // 两个Listnode，分别指向当前找出来的奇链表末尾和偶链表末尾
    public ListNode oddEvenList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode oddTail = head;
            ListNode evenTail = head.next;
            ListNode index = evenTail.next;
            int count = 2;
            while (true) {
                // 将index插到oddtail之后
                ListNode tempOddTailNext =oddTail.next;
                oddTail.next = index;
                evenTail.next = index.next;
                index.next = tempOddTailNext;
                oddTail = index;
                evenTail = evenTail.next;
                if (evenTail == null || evenTail.next == null) {
                    return head;
                }
                index = evenTail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList328 o = new OddEvenLinkedList328();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        ListNode head7 = new ListNode(7);
        ListNode head8 = new ListNode(8);
        ListNode head9 = new ListNode(9);
        ListNode head10 = new ListNode(10);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        head6.next = head7;
        head7.next = null;
        head8.next = head9;
        head9.next = head10;
        head10.next = null;

        ListNode rt = o.oddEvenList(head1);
        //ListNode rt = head1;
        while (rt != null) {
            System.out.println(rt.val);
            rt = rt.next;
        }


    }
}
