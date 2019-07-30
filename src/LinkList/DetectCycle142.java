package LinkList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        // 法一：哈希表
        if (head == null) {
            return null;
        }
        Set<ListNode> visitedNode = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (visitedNode.contains(p)) {
                return p;
            }
            visitedNode.add(p);
            p = p.next;
        }
        return null;
    }
}
