package Math;

/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings415 {

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int lenA = num1.length();
        int lenB = num2.length();
        // 将两个字符串补全到一样的长度，便于计算
        int diffLen = lenA - lenB;
        if (diffLen > 0) {  // a长b短
            while (diffLen > 0) {
                num2 = '0' + num2;
                diffLen--;
            }
        }
        if (diffLen < 0) {  // a短b长
            while (diffLen < 0) {
                num1 = '0' + num1;
                diffLen++;
            }
        }

        StringBuilder rt = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int b = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int tempSum = a + b + carry;
            if (tempSum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            rt.insert(0, tempSum % 10);
        }
        if (carry==1) {
            rt.insert(0, '1');
        }
        return rt.toString();
    }

    public static void main(String[] args) {
        AddStrings415 o = new AddStrings415();
        System.out.println(o.addStrings("148", "11125463"));
    }
}
