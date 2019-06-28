package double_pointers;

import java.lang.reflect.Array;

public class ReverseVowelsofaString345 {
    /**
     * 元音字母逆序
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char sArray[] = s.toCharArray();
        int head = 0;
        int tail = sArray.length - 1;
        while (head < tail) {
            while (!belongToVowels(sArray[head]) && head < sArray.length - 1) {
                head ++;
            }
            while (!belongToVowels(sArray[tail]) && tail > 0) {
                tail --;
            }
            if (head < tail) {
                // 交换
                char temp = sArray[tail];
                sArray[tail] = sArray[head];
                sArray[head] = temp;
                head ++;
                tail --;
            }
        }
        // 这种方式将字符数组 转为 字符串
        return new String(sArray);
    }

    /**
     * 判断参数是否为元音字母
     * @param s
     * @return boolean
     */
    public static boolean belongToVowels(char s) {
        boolean result = false;
        if (s == 'a' ||  s == 'e' || s == 'i' ||  s == 'o' || s == 'u' || s == 'A' ||  s == 'E' || s == 'I' ||  s == 'O' || s == 'U') {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseVowelsofaString345 reverseVowelsofaString345 = new ReverseVowelsofaString345();
        System.out.println(reverseVowelsofaString345.reverseVowels("OE"));
    }
}
