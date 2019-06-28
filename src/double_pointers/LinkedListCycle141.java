package double_pointers;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环
 */
// 好题
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode ptrSlow = head;
        ListNode ptrQuick = head.next;
        while (ptrQuick != ptrSlow) {
            if (ptrQuick == null || ptrQuick.next == null) {
                return false;
            }
            ptrQuick = ptrQuick.next.next;
            ptrSlow = ptrSlow.next;
        }
        return true; // 退出循环表示指针相等了
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
