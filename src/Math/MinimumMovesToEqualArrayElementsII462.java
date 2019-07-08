package Math;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 改变数组元素使所有的数组元素都相等
 * 相遇问题
 */
public class MinimumMovesToEqualArrayElementsII462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int rt = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            rt += nums[high] - nums[low];
            high--;
            low++;
        }
        return rt;
    }

    public static void main(String[] args) {
        int a[] = {1,1,1};
        new MinimumMovesToEqualArrayElementsII462().minMoves2(a);
    }
}
