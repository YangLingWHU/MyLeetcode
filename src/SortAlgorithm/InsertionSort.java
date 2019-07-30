package SortAlgorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
 * 插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
 * 插入排序的时间复杂度取决于数组的初始顺序，
 * 如果数组已经部分有序了，那么逆序较少，需要的交换次数也就较少，时间复杂度较低 O(n)。
 * 最坏的情况是数组已经逆序， O(n^2)
 */
public class InsertionSort {
    public void sort(int[] nums) {
        // 首先nums[0]只有一个元素，已经排好了序
        // 那么第一个查看的元素就是nums[1]
        // 有点像是冒泡
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                // 交换相邻的元素
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        InsertionSort o = new InsertionSort();
        int []a = {61, 1, 61, 176, 560, 74, 99};
        o.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
