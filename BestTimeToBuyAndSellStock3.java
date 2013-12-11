public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)  return 0;
        // max profit if only one trans allowed
        int profit = maxProfitHelper(prices, 0);
        // for each profitable trans, find out best profit after and get the total best
        for(int i=0, len=prices.length; i<len-3; i++)  {
            for(int j=i+1; j<len-2; j++)  {
                if(prices[j] > prices[i])  {
                    profit = Math.max(profit, prices[j] - prices[i] + maxProfitHelper(prices, j+1));
                    break;
                }
            }
        }
        return profit;
    }
    public int maxProfitHelper(int[] prices, int index) {
        int low = prices[index], high = prices[index], profit = 0;
        for(int i=index+1, len = prices.length; i<len; i++)  {
            // new low found. Calculate profit before new low
            if(prices[i] < low)  {
                profit = Math.max(profit, high-low);
                low = prices[i];
                high = low;
            }
            // record highest price to sell
            else  { 
                high = Math.max(high, prices[i]);
            }
        }
        // last case
        profit = Math.max(profit, high-low);
        return profit;
    }
}
