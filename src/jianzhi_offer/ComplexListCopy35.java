package jianzhi_offer;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba
 * 复杂链表的复制
 */
public class ComplexListCopy35 {
    // p187 面试题35
    // 使用哈希表的思路，还有更巧妙的思路
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 保存node1和node2的配对信息
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode ptrOld = pHead;
        RandomListNode ptrNew = newHead;
        map.put(ptrOld, ptrNew);
        ptrOld = ptrOld.next;
        // 首先仅仅建立新链表的next关系
        while (ptrOld != null) {
            RandomListNode temp = new RandomListNode(ptrOld.label);
            ptrNew.next = temp;
            map.put(ptrOld, temp);
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }

        // 接下来建立random关系
        ptrOld = pHead;
        ptrNew = newHead;
        while (ptrOld != null) {
            if (ptrOld.random != null) {
                // 原链表的结点所指向的原链表的结点所对应的新链表结点
                ptrNew.random = map.get(ptrOld.random);
            }
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }
        return newHead;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}