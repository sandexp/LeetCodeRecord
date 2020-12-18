class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null)
            return 0;
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>profit)
                    profit=prices[j]-prices[i];
            }
        }
        return profit;
    }
}