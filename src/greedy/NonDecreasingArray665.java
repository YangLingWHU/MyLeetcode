package greedy;


/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * 非递减数列
 */
public class NonDecreasingArray665 {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int count = 0;

        return count < 2;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-1,4, 2, 3};
        boolean rt = new NonDecreasingArray665().checkPossibility(a);
        System.out.println(rt);
    }
}
