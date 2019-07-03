package Math;

public class BaseSeven504 {
    public String convertToBase7(int num) {
        boolean negative = false;
        if (num < 0) {
            num = -1 * num;
            negative = true;
        }
        StringBuilder rt = new StringBuilder();

        while (num / 7 != 0) {
            rt.append(num % 7);
            num = num / 7;
        }
        rt.append(num);
        rt.reverse();
        return negative?"-" + rt.toString():rt.toString();
    }

    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BaseSeven504 baseSeven504 = new BaseSeven504();
        System.out.println(baseSeven504.toHex(-7));
    }
}
