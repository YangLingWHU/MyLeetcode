package BinarySearch;


/**
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int m = 0;
        while (low <= high) {
            m = low + (high - low) / 2;
            boolean isBadM = isBadVersion(m);
            if (low == high) {
                return m;
            }
            if (isBadM && !isBadVersion(m - 1)) {
                break;
            }
            if (isBadM) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        return m;
    }

    boolean isBadVersion(int version) {

        return false;
    }

    public static void main(String[] args) {
        new FirstBadVersion278().isBadVersion(2);
    }
}
