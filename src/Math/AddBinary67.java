package Math;

/**
 * https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        // 将两个字符串补全到一样的长度，便于计算
        int diffLen = lenA - lenB;
        if (diffLen > 0) {  // a长b短
            while (diffLen > 0) {
                b = '0' + b;
                diffLen--;
            }
        }
        if (diffLen < 0) {  // a短b长
            while (diffLen < 0) {
                a = '0' + a;
                diffLen++;
            }
        }

        // 进位标志
        boolean carry = false;
        StringBuilder rt = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0' && b.charAt(i) == '0' && !carry) {
                rt.insert(0, 0);
                continue;
            }
            if (a.charAt(i) == '0' && b.charAt(i) == '0' && carry) {
                rt.insert(0, 1);
                carry = false;
                continue;
            }
            if (((a.charAt(i) == '0' && b.charAt(i) == '1') || (a.charAt(i) == '1' && b.charAt(i) == '0')) && !carry) {
                rt.insert(0, 1);
                continue;
            }
            if (((a.charAt(i) == '0' && b.charAt(i) == '1') || (a.charAt(i) == '1' && b.charAt(i) == '0')) && carry) {
                rt.insert(0, 0);
                continue;
            }
            if (a.charAt(i) == '1' && b.charAt(i) == '1' && !carry) {
                rt.insert(0, 0);
                carry = true;
                continue;
            }
            if (a.charAt(i) == '1' && b.charAt(i) == '1' && carry) {
                rt.insert(0, 1);
                carry = true;
                continue;
            }
        }
        if (carry) {
            rt.insert(0, '1');
        }

        return rt.toString();
    }


    public static void main(String[] args) {
        AddBinary67 o = new AddBinary67();
        System.out.println(o.addBinary("1", "111"));
    }
}
