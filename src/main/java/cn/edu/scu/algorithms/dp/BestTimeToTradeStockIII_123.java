package cn.edu.scu.algorithms.dp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票++++。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToTradeStockIII_123 {

    /**
     * 任何时候都只可能存在5个状态:不进行任何操作,buy1,sell1,buy2,sell2
     *
     * 不进行任何操作时，就不管。
     * buy1：只进行第一次买入的最大利润
     * sell1：只进行第一次卖出的最大利润
     * buy2：进行第二次买入的最大利润
     * sell2：进行第二次卖出的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }



    // 错误版本
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        Queue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        int max_p = 0, min_p = 0;
        while (max_p < n-1) {
            int minus = prices[max_p+1] - prices[max_p];
            if (minus < 0) {
                maxQ.offer(prices[max_p] - prices[min_p]);
                min_p = max_p+1;
            }
            max_p++;
        }
        if (prices[max_p] - prices[max_p-1] >= 0) {
            maxQ.offer(prices[max_p] - prices[min_p]);
        }
        int res = 0,count = 2;
        while (!maxQ.isEmpty() && count > 0) {
            res += maxQ.poll();
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 6, 0, 0, 3, 1, 4};
        System.out.println(new BestTimeToTradeStockIII_123().maxProfit(prices));
        System.out.println(new BestTimeToTradeStockIII_123().maxProfit1(prices));

    }
}
