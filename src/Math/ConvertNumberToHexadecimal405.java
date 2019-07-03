package Math;

import java.util.Stack;

public class ConvertNumberToHexadecimal405 {
    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    // Java中，负数的二进制表示直接就是补码了.对待负数的补码，和正数一样的操作就行了
    public String toHex(int num) {
        StringBuilder rt = new StringBuilder();
        if (num == 0) {
            rt.append('0');
        }
        int count = 0;
        while (num != 0 && count < 8) {
            String binaryOfNum = Integer.toBinaryString(num);
            int i = num & 0xf;
            rt.append(map[i]);
            num = num >> 4;
            binaryOfNum = Integer.toBinaryString(num);
            count++;
        }
        return rt.reverse().toString();
    }


    public static void main(String[] args) {
        ConvertNumberToHexadecimal405 o = new ConvertNumberToHexadecimal405();
        System.out.println(o.toHex(-7));
    }
}
// -7 = fffffff9