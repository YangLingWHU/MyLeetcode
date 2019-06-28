package Heap;

import java.util.PriorityQueue;

public class KthElement {
    /**
     * 最小堆就是小顶堆
     * 最大堆就是大顶堆
     * 如果要找一个数组中的最大的k个元素，可以采用小顶堆。
     * 每次来一个新元素new的时候，就拿new和小顶堆的顶来比较大小
     * 将较小的扔掉
     * 最后的堆顶就是第k个最大的元素
     */

    /**
     * 采用优先级队列来实现堆！PriorityQueue内部是用堆实现的。
     * https://www.cnblogs.com/yongh/p/9945539.html
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (nums == null) {
            throw new RuntimeException("nums为空");
        }

        // 只要nums不为空，就不会抛出空指针异常
        for (int num : nums) {
            if (minHeap.size() >= k) {
                // peek()返回队列头元素但不移除，如果队列为空，则返回null
                if (num > minHeap.peek()) {
                    // poll() : 移除队列头的元素并且返回，如果队列为空则返回null
                    minHeap.poll();

                    // offer方法在不违背容量限制的情况，往队列中添加一个元素，如果添加元素成功，返回true，
                    // 如果因为空间限制，无法添加元素则，返回false
                    minHeap.add(num);
                }
            } else {
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    /**
     *
     // 自定义的比较器，可以让我们自由定义比较的顺序  Comparator<Integer> cmp;
     // 生成最大堆使用e2-e1,生成最小堆使用e1-e2,
     Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer e1, Integer e2) {
        return e2 - e1;
     }
     };
     //实现大根堆，此时传入了比较器cmp
     Queue<Integer> q2 = new PriorityQueue<Integer>(5, cmp);
         q2.add(2);
         q2.add(8);
         q2.add(9);
         q2.add(1);
         while (!q2.isEmpty()) {
         System. out .print(q2.poll() + "," );
     }
     */
    public static void main(String[] args) {
        System.out.println("test");
    }
}
