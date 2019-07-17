package ArrayAndMatrix;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class ReshapeMatrix566 {
    /**
     *
     * @param nums 原矩阵
     * @param r 新行数
     * @param c 新列数
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rOld = nums.length;   // 原来的行数
        int cOld = nums[0].length;  // 原来的列数
        if (rOld * cOld < r * c) {  // 原来的元素总量小于想要的总量
            return nums;
        }
        int [][]rt = new int[r][c];

        // 这两个变量表明当前正在为新数组的哪个元素赋值
        int currentR = 0;
        int currentC = 0;

        int count = 0;    // 表示当前新数组中，当前行已经有了多少个元素了
        for (int i = 0; i < rOld; i++) {
            for (int j = 0; j < cOld; j++) {
                rt[currentR][currentC] = nums[i][j];
                count++;
                currentC++;
                if (count >= c) {
                    count = 0;
                    currentR++;
                    currentC = 0;
                }
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        ReshapeMatrix566 o = new ReshapeMatrix566();
        int [][]rt = {{1,2},{3,4}};
        o.matrixReshape(rt, 1, 4);
    }
}
