package Bit;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rt = 0;
        for (int index = 0; index < 32; index++) {
            // 让rt先左移
            rt = rt << 1;
            rt = rt | (n & 1);   // n 的最低位, 次低位。。。
            n >>>= 1;
        }
        return rt;
    }

    public static void main(String[] args) {
        ReverseBits190 o = new ReverseBits190();
        System.out.println(o.reverseBits(43261596));
    }
}
