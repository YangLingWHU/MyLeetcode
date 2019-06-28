package double_pointers;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.pow;

public class SumofSquareNumbers633 {
    public boolean judgeSquareSum(int c) {
        int head = 0;
        int tail = c;
        while (head <= tail) {
            // 尽量用一个变量来存储重复需要的值
            int result = head * head + tail * tail;
            if (result == c) {
                return true;
            } else if (result > c) {
                tail --;
            } else if (result < c) {
                head ++ ;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumofSquareNumbers633 sumofSquareNumbers633 = new SumofSquareNumbers633();
        sumofSquareNumbers633.judgeSquareSum(1000000);
    }
}
