package BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 版本的完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares279_BFS {
    // 首先取得小于n的所有完全平方数
    public List<Integer> getSquaresList(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int i_2 = (int) Math.pow(i, 2);
            if (i_2 > n) {
                break;
            }
            squares.add(i_2);
        }
        return squares;
    }


    // 找到题目要求的值，采用BFS
    // int x 和 int y 看成两个节点，如果两者之间的差值正好是一个完全平方数，则说明
    public int numSquares(int n) {
        List<Integer> squares = getSquaresList(n);
        Queue<Integer> nodesForTraversal = new LinkedList<>();  // 存放每次遍历的“节点”
        nodesForTraversal.add(n);
        int level = 0;
        boolean hasMarked[] = new boolean[n + 1];
        hasMarked[n] = true;
        // 如果这种方式来写，会有ConcurrentModificationException
        // 不能使用iterator遍历集合的同时对集合进行修改
//        while (!nodesForTraversal.isEmpty()) {
//            level++;
//            for (int currentNode : nodesForTraversal) {
//                for (int square : squares) {
//                    int next = currentNode - square;
//                    if (next == 0) {
//                        return level;
//                    }
//                    if (next < 0) {
//                        break; // 为什么不是continue？
//                        // 应该是break更好一点，因为当前的square已经使得next小于0了，接下来的square也会小于零。
//                    }
//                    nodesForTraversal.add(next);
//                }
//            }
//        }

        while (!nodesForTraversal.isEmpty()) {
            level++;
            int size = nodesForTraversal.size();
            while (size > 0) {
                int currentNode = nodesForTraversal.poll();
                for (int square : squares) {
                    int next = currentNode - square;
                    if (next == 0) {
                        return level;
                    }
                    if (next < 0) {
                        break; // 为什么不是continue？
                        // 应该是break更好一点，因为当前的square已经使得next小于0了，接下来的square也会小于零。
                    }
                    if (hasMarked[next] == true) {
                        continue;
                    }
                    nodesForTraversal.add(next);
                    hasMarked[next] = true;
                }
                size--;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        PerfectSquares279_BFS o = new PerfectSquares279_BFS();

        System.out.println(o.numSquares(12));
    }
}