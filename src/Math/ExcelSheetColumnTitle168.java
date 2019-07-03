package Math;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * 也就是10进制转换为26进制
 */
public class ExcelSheetColumnTitle168 {
    // 由于下标从1开始而不是从0开始，因此要减一操作
    // 此题目看似是26进制, 但是映射关系却是从 [1, 26] 因此, 我们想的重新建立一个映射从 [0, 25]
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder rt = new StringBuilder();
        while (n != 0) {
            n--;
            rt.append((char)(n % 26 + 'A'));  // 余数是0则为A，是1则为B， 是2 则为C。。。
            n = n /26;
        }
        return rt.reverse().toString();
    }


    public static void main(String[] args) {
        ExcelSheetColumnTitle168 o = new ExcelSheetColumnTitle168();
        System.out.println(o.convertToTitle(701));
    }
}
