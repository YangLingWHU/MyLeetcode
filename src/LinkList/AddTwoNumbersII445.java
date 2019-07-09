package LinkList;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = buildStack(l1);
        Stack<ListNode> stack2 = buildStack(l2);

        // 使得两个stack等长度
        while (stack1.size() < stack2.size()) {
            stack1.add(0, new ListNode(0));
        }
        while (stack1.size() > stack2.size()) {
            stack2.add(0, new ListNode(0));
        }
        int carry = 0;
        ListNode rt = new ListNode(0);
        while (stack1.size() != 0) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = rt.next;
            rt.next = temp;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = rt.next;
            rt.next = temp;
        }
        return rt.next;
    }

    public Stack<ListNode> buildStack(ListNode l) {
        Stack<ListNode> stack1 = new Stack<>();
        while (l != null) {
            stack1.push(l);
            l = l.next;
        }
        return stack1;
    }

}
