public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)  return 0;
        int low = prices[0], high = prices[0], profit = 0;
        for(int i=1, len = prices.length; i<len; i++)  {
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
