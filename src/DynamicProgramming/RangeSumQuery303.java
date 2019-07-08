package DynamicProgramming;

public class RangeSumQuery303 {
}

class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        // 不能如下简单的传给nums变量
        // this.nums = nums;
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }

    // 如果调用多次本方法的话，使用动态规划较好。
    public int sumRange(int i, int j) {
        int rt = 0;
        for (int index = i; index <=j; index++) {
            rt += this.nums[index];
        }
        return rt;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */