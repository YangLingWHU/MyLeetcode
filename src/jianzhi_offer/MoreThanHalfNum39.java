package jianzhi_offer;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum39 {
    /**
     * 面试题39，p207
     * 使用 cnt 来统计一个元素出现的次数，
     * 当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。
     * 如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，
     * 因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
     * 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，
     * 因此继续查找就能找出 majority。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int cnt = 1;
        int currentNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == currentNum) {
                cnt++;
            } else {
                cnt--;
                if (cnt <= 0) {
                    currentNum = array[i];
                    cnt = 1;
                }
            }
        }
        cnt = 0;
        for (int num : array) {
            if (num == currentNum) {
                cnt++;
            }
        }
        return cnt * 2 > array.length ? currentNum : 0;
    }
}
