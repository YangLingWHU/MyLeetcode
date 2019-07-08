package LinkList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class SplitLinkedListInParts725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0; // 链表的长度
        ListNode i = root;
        int partsCounts = k;
        while (i != null) {
            len++;
            i = i.next;
        }
        int remainder = len % k; //余数
        List<Integer> partsLenList = new ArrayList<>();  // 存放的数字为：第一部分的数量，第二部分的数量。。。

        while (partsCounts > 0) {
            partsLenList.add(len / k + (remainder > 0 ? 1 : 0));
            remainder--;
            partsCounts--;
        }
        // System.out.println(partsLenList);

        ListNode[] rtListNode = new ListNode[k];
        rtListNode[0] = root;
        int indexOfPartsLenList = 0;
        ListNode listNode = root;
        for (int indexOfrt = 1; indexOfrt < k; indexOfrt++) {
            int partLen = partsLenList.get(indexOfPartsLenList);
            indexOfPartsLenList++;
            if (partLen == 0) {
                rtListNode[indexOfrt] = null;
                continue;
            }
            while (partLen > 1) {
                listNode = listNode.next;
                partLen--;
            }
            rtListNode[indexOfrt] = listNode.next;

            // 截断
            listNode.next = null;
            listNode = rtListNode[indexOfrt];
        }
        return rtListNode;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts725 o = new SplitLinkedListInParts725();
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
        head4.next = null;
        head5.next = null;
        head6.next = head7;
        head7.next = null;
        head8.next = head9;
        head9.next = head10;
        head10.next = null;

        ListNode[] rt = o.splitListToParts(head1, 5);
        for (int i = 0; i < rt.length; i++) {
            while (rt[i] != null) {
                System.out.println(rt[i].val);
                rt[i] = rt[i].next;
            }
        }

    }
}
