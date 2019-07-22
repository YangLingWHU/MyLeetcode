package Bit;

/**
 * https://leetcode-cn.com/problems/power-of-two/description
 */
public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 转换为2进制，最高位1，其余为0,这种情况符合条件
        boolean flag = false;
        while (n != 0) {
            int currentLow = n & 1;  // 当前n的最低位
            if (currentLow == 0) {
                n >>>= 1;
                continue;
            } else {
                if (flag) {
                    return false;
                }
                flag = true;
                n >>>= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo231 o = new PowerOfTwo231();
        System.out.println(o.isPowerOfTwo(-2147483648));
    }
}
