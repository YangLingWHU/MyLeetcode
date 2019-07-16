package jianzhi_offer;

import java.util.ArrayList;

public class PrintReverseLinkList06 {
    // p58 面试题6
    // 从尾到头输出链表
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}