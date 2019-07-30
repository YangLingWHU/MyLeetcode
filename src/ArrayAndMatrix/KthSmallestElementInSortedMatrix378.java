package ArrayAndMatrix;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 参考 https://www.jianshu.com/p/a174f3fc36cb
 */
public class KthSmallestElementInSortedMatrix378 {
    // 采用小顶堆
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // 矩阵特点：左上角的一定是最小的，左上角的右或者下是第二小的
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        minHeap.offer(new Tuple(0, 0, matrix[0][0]));
        boolean[][] hasTraversaled = new boolean[matrix.length][matrix[0].length];
        while (k > 1) {
            Tuple top = minHeap.poll();
            if (top.j + 1 < matrix[0].length && !hasTraversaled[top.i][top.j + 1]) {
                minHeap.offer(new Tuple(top.i, top.j + 1, matrix[top.i][top.j + 1]));  // 右边的元素
                hasTraversaled[top.i][top.j + 1] = true;
            }
            if (top.i + 1 < matrix.length && !hasTraversaled[top.i + 1][top.j]) {
                // 下边的元素
                minHeap.offer(new Tuple(top.i + 1, top.j, matrix[top.i + 1][top.j]));  // 右边的元素
                hasTraversaled[top.i + 1][top.j] = true;
            }
            k--;
        }
        return minHeap.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int i;  // 行号
        int j;  // 列号
        int val; // 值

        public Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int a[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallestElementInSortedMatrix378 o = new KthSmallestElementInSortedMatrix378();
        System.out.println(o.kthSmallest(a, 8));
    }
}
