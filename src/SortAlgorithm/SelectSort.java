package SortAlgorithm;

import java.util.Arrays;

/**
 * 选择排序
 * 它的运行时间与输入无关，这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作
 */
public class SelectSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;  // 存放当前找到的最小值的下标
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectSort o = new SelectSort();
        int []a = {61, 1, 61, 176, 560, 74, 99};
        o.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
