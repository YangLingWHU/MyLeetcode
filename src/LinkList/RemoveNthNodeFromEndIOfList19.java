package LinkList;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/comments/
 */
public class RemoveNthNodeFromEndIOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 两个指针，post先行出发n个单位
        ListNode pre = head;
        ListNode post = head;
        while (n > 0) {
            n--;
            post = post.next;
        }
        // 注意本条件
        if (post == null) {
            return head.next;
        }
        while (post.next != null) {
            pre = pre.next;
            post = post.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
