package 剑指offer_后缀为书中题号;

/**
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class GetNextInTree08 {
    // p65 面试题8
    // 二叉树中序遍历，给出当前节点的下一个访问节点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode rt = pNode;
        // 1.如果该节点有右子树，那么下一个节点就是右子树中第一个访问的节点
        if (pNode.right != null) {
            rt = pNode.right;
            while (rt.left != null) {
                rt = rt.left;
            }
            return rt;
        }

        // 2.如果该节点没有右子树
        // 2.1 如果该节点没有父节点，没有下一个
        if (pNode.right == null && pNode.next == null) {
            return null;
            //return null;  // 如果是rt = null，那么接下来可能会进入其他if语句
        }
        // 2.2 如果该节点有父节点且是父节点的左子节点，那么下一个就是父节点
        if (pNode.right == null && pNode.next.left == pNode) {
            rt =  pNode.next;
        }
        // 2.3 如果该节点有父节点且是父节点的右子节点
        if (pNode.right == null && pNode.next.right == pNode) {
            // 找到该节点的某个祖先节点p。
            rt = pNode;
            // 2.3.1 有父节点p.next，p是p.next的左孩子，最后返回p.next
            // 2.3.2 如果p没有父节点，返回p

            while (rt.next != null && rt.next.left != rt) {
                rt = rt.next;
            }
            if (rt.next == null) {
                rt = null;  // 这样写是为了便于理解
            } else {
                rt = rt.next;
            }
        }
        return rt;
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 代表父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}