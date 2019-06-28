package double_pointers;

import java.util.Map;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergedTail = m + n - 1;  // 合并之后的数组的最后位置
        int nums1Tail = m - 1;
        int nums2Tail = n - 1;
        while (nums1Tail >= 0 && nums2Tail >= 0) {
            if (nums1[nums1Tail] >= nums2[nums2Tail]) {
                nums1[mergedTail] = nums1[nums1Tail];
                nums1Tail--;
            } else if (nums1[nums1Tail] < nums2[nums2Tail]) {
                nums1[mergedTail] = nums2[nums2Tail];
                nums2Tail--;
            }
            mergedTail--;
        }

        // 退出循环后，
        if (nums1Tail < 0) {
            for (int i = nums2Tail; i >= 0; i--) {
                nums1[mergedTail] = nums2[i];
                mergedTail--;
            }
        }

        if (nums2Tail < 0) {
            for (int i = nums1Tail; i >= 0; i--) {
                nums1[mergedTail] = nums1[i];
                mergedTail--;
            }
        }
    }
}
