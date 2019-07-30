package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class PowerOfX16 {
    // p110,面试题16.求base的exponent次方。
    public double Power(double base, int exponent) {
        // 任何数的0次方都是1
        if (exponent == 0) {
            return 1;
        }
        if (base == 0.0) {
            return 0;
        }
        boolean isExponentNegetive = false;
        if (exponent < 0) {
            isExponentNegetive = true;
            exponent = -1 * exponent;
        }
        double rt = 1;
        for (int i = 0; i < exponent; i++) {
            rt = rt * base;
        }
        if (isExponentNegetive) {
            rt = 1 / rt;
        }
        return rt;
    }
}
