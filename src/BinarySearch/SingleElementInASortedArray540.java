package BinarySearch;


/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray540 {

    // 遍历算法，比较慢
//    public int singleNonDuplicate(int[] nums) {
//        int index = 0;
//        while (index < nums.length - 1) {
//            if (nums[index] != nums[index+1]) {
//                break;
//            }
//            index += 2;
//        }
//        return nums[index];
//    }

    // 改为二分查找
    public int singleNonDuplicate(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int m = (high + low) / 2;
            if (m == 0 || m == nums.length - 1) {
                return nums[m];
            }
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            }

            if (nums[m] == nums[m - 1] && nums[m] != nums[m + 1]) {
                if (m % 2 == 0) { // 左侧元素个数为偶数
                    high = m- 1;
                    continue;
                } else {    // 左侧元素个数为奇数
                    low = m + 1;
                    continue;
                }

            }
            if (nums[m] != nums[m - 1] && nums[m] == nums[m + 1]) {
                if (m% 2 == 0) { // 左侧元素个数为偶数
                    low = m+ 1;
                    continue;
                } else {    // 左侧元素个数为奇数
                    high = m - 1;
                    continue;
                }
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int a[] = {1,1,2,2,3};
        System.out.println(new SingleElementInASortedArray540().singleNonDuplicate(a));
    }
}
