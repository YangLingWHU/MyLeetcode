package BinarySearch;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 寻找比目标字母大的最小字母
 */
public class FindSmallestLetterGreaterThanTarget744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (target >= letters[len - 1]) {
            return letters[0];
        }

        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (letters[m] == target && letters[m + 1] > target) {
                return letters[m + 1];
            }
            if (letters[m] == target) {
                low++;
            }
            if (letters[m] > target) {
                high = m - 1;
                continue;
            }
            if (letters[m] < target) {
                low = m + 1;
                continue;
            }
        }
        return letters[low];
    }

    public static void main(String[] args) {
        String str = "eeeeeennnn";
        char a[] = str.toCharArray();
        char rt = new FindSmallestLetterGreaterThanTarget744().nextGreatestLetter(a,'e');
        System.out.println(rt);
    }
}

