package LinkList;

public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        while (j != null) {
            while (j!=null && i.val == j.val ) {
                j = j.next;
            }
            i.next = j;
            i =j;
        }
        return head;
    }
}
