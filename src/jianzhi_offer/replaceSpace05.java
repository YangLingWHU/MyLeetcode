package jianzhi_offer;

// 牛客网剑指offer系列 第二题

public class replaceSpace05 {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLen = str.length() + 2 * count;
        str.setLength(newLen);
        for (int i = oldLen - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(i + 2 * count, str.charAt(i));
            } else {

                str.setCharAt(i + 2 * count - 2, '%');
                str.setCharAt(i + 2 * count - 1, '2');
                str.setCharAt(i + 2 * count, '0');
                count--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("We Are Happy.");
        replaceSpace05 o = new replaceSpace05();
        System.out.println(o.replaceSpace(a));
    }
}
