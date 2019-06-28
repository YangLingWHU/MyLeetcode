package BinarySearch;

public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int m = 0;
        while (low <= high) {
            m = low + (high - low) / 2;

        }
        return 0;
    }

    public static void main(String[] args) {

        int a[] = {1,2,3,4,5};
        int rt = new FindMinimuminRotatedSortedArray153().findMin(a);
        System.out.println(rt);
    }
}
