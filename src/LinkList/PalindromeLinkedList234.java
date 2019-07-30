package LinkList;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 判断链表是不是回文链表
 */
public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针法。有关栈的部分可以改进，在p1前进的时候就顺便压栈。
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        if (p2 == null) {
            // 如果是偶数个节点，那么p2指向null,p1指向中间靠右

        } else if (p2.next == null) {
            // 如果是奇数个节点，那么p2指向最后一个,p1指向正中间
            p1 = p1.next;
        }
        while (p1 != null) {
            stack.push(p1);
            p1 = p1.next;
        }

        // 此时p1 p2 的身份不再是快慢指针
        p1 = head;
        while (stack.size() != 0) {
            p2 = stack.pop();
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
        }
        return true;
    }
}
