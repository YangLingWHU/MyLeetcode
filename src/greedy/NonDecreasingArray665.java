package greedy;


/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * 非递减数列
 * 参考  https://blog.csdn.net/qq_34594236/article/details/77909200
 */
public class NonDecreasingArray665 {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 1 == 0 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                    continue;
                }
                if(nums[i-2] > nums[i]) {
                    nums[i] = nums[i-1];
                }
            }
        }

        return count < 2;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-1, 4, 2, 3};
        boolean rt = new NonDecreasingArray665().checkPossibility(a);
        System.out.println(rt);
    }
}
