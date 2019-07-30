package SortAlgorithm;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/bingxing/p/9356402.html
 */
public class QuickSortP80 {
    public void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(data, start, end);
        quickSort(data, pivot + 1, end);
        quickSort(data, start, pivot - 1);
    }

    // 选择待partition的数组的第一个元素为pivot
    // 将所有大于pivot的放在右边，小于的放在左边
    // 交替式逼近法
    // 返回值是中轴的下标
    public int partition(int[] data, int start, int end) {
        int pivot = data[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (data[high] >= pivot && low < high) {
                high--;
            }
            data[low] = data[high];
            while (data[low] < pivot && low < high) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        QuickSortP80 o = new QuickSortP80();
        int a[] = {61, 1, 61, 176, 560, 74, 99};
        o.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


}
