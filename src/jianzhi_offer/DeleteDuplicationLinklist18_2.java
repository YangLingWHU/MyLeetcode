package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef
 */
public class DeleteDuplicationLinklist18_2 {
    // p122 面试题18的题目二，删除有序链表的重复值
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 一个虚拟头节点利于计算
        ListNode vHead = new ListNode(1);
        vHead.next = pHead;
        ListNode p1 = vHead;
        ListNode p2 = p1.next;
        while (p2 != null && p2.next != null) {
            if (p2.val == p2.next.val) {
                while (p2 != null && p2.val == p1.next.val) {
                    p2 = p2.next;
                }
                p1.next = p2;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return vHead.next;
    }
}
