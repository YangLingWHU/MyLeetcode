package Holland_Flag;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors75 {

    // 如何不使用简单的思想？比如：计算每种元素的数量，再重新组成数组.
    // 需要多次练习
    public void sortColors(int[] nums) {
        int i = 0;
        int lessThan1 = 0;
        int moreThan1 = nums.length - 1;
        while (i <= moreThan1) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, lessThan1);
                lessThan1++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, moreThan1);
                moreThan1--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int a[] = {2, 0, 2, 1, 1, 0};
        new SortColors75().sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}

