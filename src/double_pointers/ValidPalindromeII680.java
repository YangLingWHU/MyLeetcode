package double_pointers;

public class ValidPalindromeII680 {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     */
    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        // 先一个字符都不删除进行一次判断
        if (isPalindrome(s) == true) {
            return true;
        }
        int strLength = s.length();

        /*
        //删除一个字符，从开头挨个删除进行尝试.本方式会超时！！
        for (int i = 0; i < strLength; i++) {
            String str = s.substring(0, i) + s.substring(i + 1, strLength);
            if (isPalindrome(str)) {
                return true;
            };
        }
         */

        // 尽可能的减小字符串的长度
        while (head < tail) {
            if (s.charAt(head) == s.charAt(tail)){
                head ++;
                tail --;
            } else {
                break;
            }
        }

        // 从外到内一层层剥离
        // 跳出while时，就是head和tail不相等的地方
        String str = s.substring(head + 1, tail + 1); // 去掉左边
        if (isPalindrome(str)) {
            return true;
        };
        str = s.substring(head, tail); // 去掉右边
        if (isPalindrome(str)) {
            return true;
        };
        return false;
    }

    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head ++) != s.charAt(tail --)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII680 validPalindromeII680 = new ValidPalindromeII680();
        System.out.println(validPalindromeII680.validPalindrome("aabca"));
    }
}
