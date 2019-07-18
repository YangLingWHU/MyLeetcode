package ArrayAndMatrix;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 */
public class SetMismatch645 {
    // 既然是 1-n，开个 n 容量的数组，存数出现的个数，如果出现 0 次的，就是缺的数，出现 2 次的，就是重复的数
    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        int miss = 0;
        int[] bucket = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                miss = i;
            }
            if (bucket[i] == 2) {
                dup = i;
            }
        }
        return new int[]{dup, miss};
    }

    public static void main(String[] args) {
        SetMismatch645 o = new SetMismatch645();
        o.findErrorNums(new int[]{1,1});
    }
}
