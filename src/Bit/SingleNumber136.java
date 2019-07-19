package Bit;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber136 {

    /**
     * 异或运算（XOR）满足结合律
     * 相同的数字异或结果为0000，那么两两出现的数字都配对异或，最后省下来待求的数字和0000来异或
     * 无关正负数
     * 4^2^1^2^1调整顺序变成1^1^2^2^4
     */
    public int singleNumber(int[] nums) {
        int rt = 0;
        for (int num : nums) {
            rt ^= num;
        }
        return rt;
    }
}
