package BinarySearch;


public class Sqrt_X_69 {
    public int mySqrt(int x) {

        // 计算m平方时，乘法容易溢出，尝试改为除法的方式
        if (x <= 1) {
            return x;
        }
        int high = x / 2;
        int low = 1;
        while (low < high) {
            int m = (low + high) / 2;

            if (Math.pow(m, 2) <= x && Math.pow(m+1, 2) > x) {
                return m;
            }
            if (Math.pow(m, 2) > x) {
                high = m - 1;
                continue;
            }
            if (Math.pow(m, 2) < x) {
                low = m + 1;
                continue;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        System.out.println(new Sqrt_X_69().mySqrt(2147395599));

    }
}
