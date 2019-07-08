package LinkList;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/submissions/
 */
public class IntersectionOfTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 一种思路：将两个链表都遍历一遍，取得各自的长度lenA和lenB，将较长的先走lenA-lenB个单位。
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = lenA - lenB;
        if (diff > 0) {  // lenA > lenB;
            while (diff != 0) {
                diff--;
                headA = headA.next;
            }
        } else if (diff < 0) {  // lenA < lenB;
            while (diff != 0) {
                diff++;
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
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
