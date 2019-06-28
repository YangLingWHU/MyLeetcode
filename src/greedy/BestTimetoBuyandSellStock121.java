package greedy;


// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票）
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        int len = prices.length;
        int minBeforeIndex = prices[0];

        /**
         * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益
         *
         * 从数组的第二个元素开始遍历，每次与prices[index]的之前的元素中的最小值minBeforeIndex进行比较
         * 如何找到minBeforeIndex？不用特意设计算法
         */
        for (int index = 1; index < len; index++) {
            if (minBeforeIndex > prices[index]) {
                minBeforeIndex = prices[index];
            } else {
                max = Math.max(max, prices[index] - minBeforeIndex);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int a[] = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimetoBuyandSellStock121().maxProfit(a));
    }
}
