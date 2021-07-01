class Solution {

    /**
    假设
    dp[i]为到第i天最大利润
    dp[0] 为0
     */
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int[] dp=new int[prices.length];
        dp[0]=0;
        int minu=prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i]=Math.max(dp[i-1],prices[i]-minu);
            minu=Math.min(minu,prices[i]);
        }
        return dp[prices.length-1];
    }
}