package jianzhi_offer;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 * 最小的k个数
 */
public class SmallestKNums40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> rt = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return rt;
        }

        // 大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int inputNum : input) {
            if (maxHeap.size() < k) {
                maxHeap.offer(inputNum);
            } else {
                int topHeap = maxHeap.peek();
                if (topHeap > inputNum) {
                    maxHeap.offer(inputNum);
                    maxHeap.poll();
                }
            }
        }
        while (maxHeap.size() != 0) {
            rt.add(maxHeap.poll());
        }
        Collections.sort(rt);
        return rt;
    }

    public static void main(String[] args) {
        SmallestKNums40 o = new SmallestKNums40();
        int[] a = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = o.GetLeastNumbers_Solution(a, 4);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
