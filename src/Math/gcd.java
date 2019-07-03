package Math;

/**
 * 求最大公约数，辗转相除法
 */
public class gcd {
    // 最小公约数
    public int gcd(int i, int j) {
        int result = i % j;
        while (result != 0){
            i = j;
            j = result;
            result = i % j;
        }
        return j;
    }

    // 最大公倍数 乘积除以最小公约数

    public static void main(String[] args) {
        gcd o = new gcd();
        System.out.println(o.gcd(319, 377));
    }
}
