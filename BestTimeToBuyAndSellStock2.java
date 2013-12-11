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
}
