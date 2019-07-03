package Math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerOfThree326 {
    // 用 map 也不会减少时间
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        long i = 1;
        while (i < n) {
            i = i * 3;
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PowerOfThree326 o = new PowerOfThree326();
        System.out.println(o.isPowerOfThree(2147483647));
    }
}
