package BinarySearch;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare367 {
    // 二分查找
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double cal = num * 1.0 / mid;
            if (cal == mid) {
                return true;
            }
            if (cal < mid) {
                high = mid - 1;
            } else if (cal > mid) {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare367 o = new ValidPerfectSquare367();
        System.out.println(o.isPerfectSquare(100000000));
    }
}
