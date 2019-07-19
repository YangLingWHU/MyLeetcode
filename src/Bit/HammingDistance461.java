package Bit;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance461 {
    // 负数的存储以补码形式,此时只考虑正数
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int rt = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                rt++;
            }
            // 此时仅考虑正数，那么xor的最高位肯定是0，算术右移和无符号右移没有区别
            xor = xor >>> 1;
        }
        return rt;
    }


    public static void main(String[] args) {
        HammingDistance461 o = new HammingDistance461();
        System.out.println(o.hammingDistance(1, 4));
    }
}
