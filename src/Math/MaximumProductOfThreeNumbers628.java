package Math;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers628 {

    // 两个优先级队列，当作最大堆，分别存放正数和负数
    public int maximumProduct(int[] nums) {
//        PriorityQueue<Integer> positiveHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> negativeHeap = new PriorityQueue<>();
//        for (int num : nums) {
//            if (num >= 0) {
//
//            }
//        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                        nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);

    }
}
