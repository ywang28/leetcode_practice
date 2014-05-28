public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)  return 0;
        int low = prices[0], high = prices[0], profit = 0;
        for(int i=1, len = prices.length; i<len; i++)  {
            // keep track of high records
            if(prices[i] > high)  {
                high = prices[i];
            }
            // price drop. need to sell at previous high
            else  {
                profit += high-low;
                low = prices[i];
                high = low;
            }
        }
        // last case
        profit += high-low;
        return profit;
    }
    public int maxProfit2nd(int[] prices) {
        if(prices == null || prices.length < 2)  return 0;
        int low = prices[0], high = -1, profit = 0;
        for(int i = 1; i < prices.length; i++)  {
            if(prices[i] < high)  {
                profit += high - low;
                low = prices[i];
                high = low;
            }
            else if(prices[i] <= low) {
                low = prices[i];
                high = low;
            }
            else  {
                high = prices[i];
            }
        }
        if(high > low)  profit += high - low;
        return profit;
    }
}
